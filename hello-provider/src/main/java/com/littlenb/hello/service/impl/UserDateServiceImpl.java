package com.littlenb.hello.service.impl;

import com.littlenb.hello.entity.UserArchiveEntity;
import com.littlenb.hello.entity.UserEntity;
import com.littlenb.hello.mapper.UserArchiveUpdateMapper;
import com.littlenb.hello.mapper.UserQueryMapper;
import com.littlenb.hello.mapper.UserUpdateMapper;
import com.littlenb.hello.service.UserDataService;
import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author svili
 **/
public class UserDateServiceImpl implements UserDataService {

  @Autowired
  private UserQueryMapper userQueryMapper;

  @Autowired
  private UserUpdateMapper userUpdateMapper;

  @Autowired
  private UserArchiveUpdateMapper userArchiveUpdateMapper;

  // @Transactional
  @Override
  public void insertUser(UserEntity entity) {
    Validate.notNull(entity);
    Validate.notNull(entity.getUserId());
    userUpdateMapper.insertSelective(entity);

    UserArchiveEntity archive = entity.getArchive();
    if (archive != null) {
      Validate.isTrue(Objects.equals(entity.getUserId(), archive.getUserId()));
    }
    userArchiveUpdateMapper.insertSelective(entity.getArchive());
  }

  @Override
  public void updateUserById(UserEntity user) {
    Validate.notNull(user);
    Validate.notNull(user.getUserId());

    userUpdateMapper.updateSelectiveById(user);
  }

  @Override
  public void updateArchiveById(UserArchiveEntity archive) {
    Validate.notNull(archive);
    Validate.notNull(archive.getUserId());

    userArchiveUpdateMapper.updateSelectiveById(archive);
  }

  @Override
  public long queryUserIdByUniCode(String uniCode) {
    Validate.notBlank(uniCode);
    Long userId = userQueryMapper.selectUserIdByUniCode(uniCode);
    if (userId == null) {
      throw new IllegalArgumentException("uniCode is not exist.");
    }
    return userId;
  }

  @Override
  public long queryUserIdByPhone(String mobilePhone) {
    Validate.notBlank(mobilePhone);
    Long userId = userQueryMapper.selectUserIdByPhone(mobilePhone);
    if (userId == null) {
      throw new IllegalArgumentException("uniCode is not exist.");
    }
    return userId;
  }

  @Override
  public UserEntity queryUserById(long userId) {
    return userQueryMapper.selectUnionById(userId);
  }

  @Override
  public UserArchiveEntity queryArchiveById(long userId) {
    return userQueryMapper.selectArchiveById(userId);
  }


}
