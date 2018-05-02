package com.littlenb.hello.api;

import com.littlenb.hello.api.dto.UserDto;

/**
 * 用户服务
 *
 * @author svili
 **/
public interface UserService {

  /**
   * query by unionCode
   *
   * @param uniCode 用户唯一识别码
   */
  UserDto queryByUniCode(String uniCode);

  /**
   * 更新用户手机号码
   */
  boolean updateMobilePhone(String uniCode, String mobilePhone);

  boolean verifyPasswordByUniCode(String uniCode, String password);

  boolean verifyPasswordByPhone(String mobilePhone, String password);

}
