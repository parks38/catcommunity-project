package com.project.catcaring.mapper;

import com.project.catcaring.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 회원 API (Mapper)
 */
@Mapper
public interface UserMapper {

    /**
     * 회원 생성
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 회원 username unique 체크
     *
     * @param username
     * @return
     */
    boolean isUniqueUsername(String username);

    /**
     * username 으로 회원 찾기
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * userId 로 회원 찾기
     *
     * @param userId
     * @return
     */
    User findByUserId(Long userId);

    /**
     * 회원 탈퇴
     *
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 회원 정보 수정
     *
     * @param user
     */
    void updateUser(User user);
}
