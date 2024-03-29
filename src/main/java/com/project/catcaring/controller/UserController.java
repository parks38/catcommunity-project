package com.project.catcaring.controller;

import static com.project.catcaring.error.HttpResponses.RESPONSE_CREATED;
import static com.project.catcaring.error.HttpResponses.RESPONSE_OK;

import com.project.catcaring.aop.annotation.CheckLogin;
import com.project.catcaring.domain.User;
import com.project.catcaring.dto.user.request.UserInfoRequest;
import com.project.catcaring.dto.user.request.UserLoginRequest;
import com.project.catcaring.error.LoginErrorException;
import com.project.catcaring.service.user.LoginSessionService;
import com.project.catcaring.service.user.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 회원 기본 API (Controller)
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Api(value = "/auth", tags = "user")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final LoginSessionService loginSessionService;

    /**
     * 회원 가입
     *
     * @param userInfoRequest
     * @return
     */
    @ApiOperation(value = "가입하기", notes = "가입하기")
    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody @NonNull UserInfoRequest userInfoRequest) {

        userServiceImpl.createUser(userInfoRequest);

        return RESPONSE_CREATED;
    }

    /**
     * 회원 로그인
     *
     * @param userLoginRequest
     * @return
     */
    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @NonNull UserLoginRequest userLoginRequest) {
        Optional<User> user = userServiceImpl
            .login(userLoginRequest.getUsername(), userLoginRequest.getPassword());

        if (user.isPresent()) {
            loginSessionService.loginUser(user.get().getId());
            return RESPONSE_OK;
        }

        throw new LoginErrorException(HttpStatus.NOT_FOUND);
    }

    /**
     * 회원 로그아웃
     *
     * @return
     */
    @ApiOperation(value = "로그아웃")
    @GetMapping("/logout")
    @CheckLogin
    public ResponseEntity<String> logout() {

        loginSessionService.logoutUser();

        return RESPONSE_OK;
    }
}
