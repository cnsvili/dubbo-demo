package com.littlenb.hello.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.littlenb.hello.api.dto.UserDto;
import com.littlenb.hello.entity.UserEntity;

/**
 * @author svili
 **/
public class UserDtoAdaptor {

  public static UserDto toDto(UserEntity entity) {
    if (entity == null) {
      return null;
    }

    JSONObject json = (JSONObject) JSON.toJSON(entity);
    json.putAll((JSONObject) JSON.toJSON(entity.getArchive()));

    return json.toJavaObject(UserDto.class);
  }

}
