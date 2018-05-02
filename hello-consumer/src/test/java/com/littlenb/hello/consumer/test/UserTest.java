package com.littlenb.hello.consumer.test;

import com.alibaba.fastjson.JSON;
import com.littlenb.hello.api.UserService;
import com.littlenb.hello.api.dto.UserDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author svili
 **/
public class UserTest extends AbstractTest {

  @Autowired
  private UserService userService;

  @Test
  public void test() {
    String uniCode = "user_2";
    UserDto result = userService.queryByUniCode(uniCode);
    System.out.println(JSON.toJSONString(result));
  }
}
