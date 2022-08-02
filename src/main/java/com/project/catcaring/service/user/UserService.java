package com.project.catcaring.service.user;

import com.project.catcaring.domain.User;
import com.project.catcaring.dto.user.request.UserInfoRequest;
import java.util.Optional;

/**
 * 회원 기본 API (Service)
 * <p>
 * 회원 생성 및 로그인
 */
public interface UserService {

    /**
     * 회원 로그인
     *
     * @param username
     * @param password
     * @return
     */
    Optional<User> login(String username, String password);

    /**
     * 사용자 가입
     *
     * @param userInfoRequest
     */
    void createUser(UserInfoRequest userInfoRequest);
}
