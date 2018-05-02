package com.littlenb.hello.api.impl;

import com.littlenb.hello.api.UserDtoAdaptor;
import com.littlenb.hello.api.UserService;
import com.littlenb.hello.api.dto.UserDto;
import com.littlenb.hello.entity.UserArchiveEntity;
import com.littlenb.hello.entity.UserEntity;
import com.littlenb.hello.service.UserDataService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author svili
 **/
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDataService userDataService;

  @Override
  public UserDto queryByUniCode(String uniCode) {
    Long userId = userDataService.queryUserIdByUniCode(uniCode);
    UserEntity entity = userDataService.queryUserById(userId);
    return UserDtoAdaptor.toDto(entity);
  }

  @Override
  public boolean updateMobilePhone(String uniCode, String mobilePhone) {
    Long userId = userDataService.queryUserIdByUniCode(uniCode);
    UserArchiveEntity archive = new UserArchiveEntity();
    archive.setUserId(userId);
    archive.setMobilePhone(mobilePhone);
    userDataService.updateArchiveById(archive);
    return true;
  }

  @Override
  public boolean verifyPasswordByUniCode(String uniCode, String password) {
    Long userId = userDataService.queryUserIdByUniCode(uniCode);
    // 能获取到id,则user一定存在
    UserEntity user = userDataService.queryUserById(userId);

    return Objects.equals(user.getPassword(), password);
  }

  @Override
  public boolean verifyPasswordByPhone(String mobilePhone, String password) {
    Long userId = userDataService.queryUserIdByPhone(mobilePhone);
    // 能获取到id,则user一定存在
    UserEntity user = userDataService.queryUserById(userId);

    return Objects.equals(user.getPassword(), password);
  }
}
