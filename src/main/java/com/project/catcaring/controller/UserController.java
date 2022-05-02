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
    유저 로그인 상태와 가입을 담당 합니다. 

    의존성 주입을 @Autowired 방식이 아닌 final 필드를 이용했기 때문에 
    해당 필드에 대한 생성자를 위해 @RequiredArgsConstructor 어노테이션을 사용합니다. 

    @author suna.park
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

 private final UserServiceImpl userServiceImpl;
 private final LoginSessionService loginSessionService;

/**
    유저 가입하기

    @NonNull 을 통해 front-end 에서 막지 못한 null check 
 */ 
  @PostMapping
  public ResponseEntity<String> signUp(@RequestBody @NonNull UserInfoRequest userInfoRequest) {
    userServiceImpl.createUser(userInfoRequest);
    return RESPONSE_CREATED;
  }

/**
    유저 로그인 및 로그인 상태 확인 

    @NonNull 을 통해 front-end 에서 막지 못한 null check 
 */
  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody @NonNull UserLoginRequest userLoginRequest) {
    Optional<User> user = userServiceImpl.login(userLoginRequest.getUsername(), userLoginRequest.getPassword());
    if (user.isPresent()) {
      loginSessionService.loginUser(user.get().getId());
      return RESPONSE_OK;
    }
    throw new LoginErrorException(HttpStatus.NOT_FOUND);
  }

/**
    유저 로그아웃 하기
    
    @CheckLogin 은 AOP 를 이용하여 부가 로직을 제거하였습니다. 
    어노테이션이 붙은 메소드만 로그인 체크를 합니다. 
 */
  @GetMapping("/logout")
  @CheckLogin
  public ResponseEntity<String> logout() {
    loginSessionService.logoutUser();
    return RESPONSE_OK;
  }
}
