package com.project.catcaring.service.user;

import com.project.catcaring.domain.User;
import com.project.catcaring.dto.user.request.UserInfoRequest;
import com.project.catcaring.error.DuplicateIdException;
import com.project.catcaring.mapper.UserMapper;
import com.project.catcaring.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 기본 API (Service)
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    /**
     * 회원 생성
     *
     * @param userInfoRequest
     */
    @Override
    @Transactional
    public void createUser(UserInfoRequest userInfoRequest) {

        // username unique 확인
        if (isUniqueUsername(userInfoRequest.getUsername())) {
            throw new DuplicateIdException();
        }

        userRepository.save(User.generate(userInfoRequest));
    }

    /**
     *  회원 유저 네임 unique 체크
     *
     * @param username
     * @return
     */
    @Transactional(readOnly = true)
    public boolean isUniqueUsername(String username) {

        return userMapper.isUniqueUsername(username);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<User> login(String username, String password) {

        Optional<User> currentUser = Optional.ofNullable(userMapper.findByUsername(username));

        return checkPassword(password, currentUser);
    }

    private Optional<User> checkPassword(String password, Optional<User> currentUser) {

        if (currentUser.isPresent()) {
            boolean comparePassword = BCrypt.checkpw(password, currentUser.get().getPassword());

            if (comparePassword) {
                return currentUser;
            }
        }
        return Optional.empty();
    }
}
