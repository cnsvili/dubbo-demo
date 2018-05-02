package com.littlenb.hello.mapper;

import com.littlenb.hello.entity.UserArchiveEntity;
import com.littlenb.hello.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author svili
 */
@Mapper
@Repository
public interface UserQueryMapper {

  @Select("SELECT * FROM t_sys_user WHERE user_id = #{userId}")
  UserEntity selectUserById(long userId);

  @Select("SELECT * FROM t_sys_user_archive t WHERE t.user_id = #{userId}")
  UserArchiveEntity selectArchiveById(long userId);

  UserEntity selectUnionById(long userId);

  @Select("SELECT user_id FROM t_sys_user WHERE uni_code = #{uniCode}")
  Long selectUserIdByUniCode(String uniCode);

  @Select("SELECT user_id FROM t_sys_user WHERE mobile_phone = #{mobilePhone}")
  Long selectUserIdByPhone(String mobilePhone);

}
