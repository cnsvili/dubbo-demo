package com.littlenb.hello.service;

import com.littlenb.hello.entity.UserArchiveEntity;
import com.littlenb.hello.entity.UserEntity;

/**
 * @author svili
 **/
public interface UserDataService {

  void insertUser(UserEntity entity);

  void updateUserById(UserEntity user);

  void updateArchiveById(UserArchiveEntity archive);

  long queryUserIdByUniCode(String uniCode);

  long queryUserIdByPhone(String mobilePhone);

  UserEntity queryUserById(long userId);

  UserArchiveEntity queryArchiveById(long userId);

}
