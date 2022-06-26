package com.project.catcaring.service.user;

import com.project.catcaring.domain.User;
import com.project.catcaring.dto.user.request.UserChangeRequest;
import com.project.catcaring.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserApiServiceImpl implements UserApiService{

  private final UserMapper userMapper;

  @Override
  @Transactional(readOnly = true)
  public User getUserInfo(Long userId) {
    return userMapper.findByUserId(userId);
  }

  @Override
  @Transactional
  public void deleteUser(Long userId) {
    userMapper.deleteUser(userId);
  }

  @Override
  @Transactional
  public void updateUser(UserChangeRequest userChangeRequest, Long userId) {
    userMapper.updateUser(User.modify(userChangeRequest, userId));
  }
}
