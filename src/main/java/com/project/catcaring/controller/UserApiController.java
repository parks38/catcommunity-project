package com.project.catcaring.controller;

import static com.project.catcaring.error.HttpResponses.*;

import com.project.catcaring.aop.annotation.CheckLogin;
import com.project.catcaring.domain.User;
import com.project.catcaring.dto.user.request.UserChangeRequest;
import com.project.catcaring.service.user.LoginSessionService;
import com.project.catcaring.service.user.UserApiServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
@Api(value = "/users", tags = "사용자 정보")
public class UserApiController {

    private final UserApiServiceImpl userServiceImpl;
    private final LoginSessionService loginSessionService;

    @GetMapping
    @CheckLogin
    @ApiOperation(value="사용자 정보 불러오기")
    public ResponseEntity<User> getUserInfo() {

        return ResponseEntity
            .ok(userServiceImpl.getUserInfo(loginSessionService.getCurrentUserId()));
    }

    @DeleteMapping
    @CheckLogin
    @ApiOperation(value="사용자 탈퇴")
    public ResponseEntity<String> deleteUser() {

        userServiceImpl.deleteUser(loginSessionService.getCurrentUserId());
        loginSessionService.logoutUser();

        return new ResponseEntity<>("user delete completed", HttpStatus.NO_CONTENT);
    }

    @PatchMapping
    @CheckLogin
    @ApiOperation(value= "사용자 정보 수정")
    public ResponseEntity<String> updateUser(@RequestBody UserChangeRequest userChangeRequest) {

        userServiceImpl.updateUser(userChangeRequest, loginSessionService.getCurrentUserId());

        return RESPONSE_OK;
    }
}
