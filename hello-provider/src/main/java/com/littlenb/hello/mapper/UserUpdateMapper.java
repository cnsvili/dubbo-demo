package com.littlenb.hello.mapper;

import com.littlenb.hello.entity.UserEntity;
import com.mybatis.jpa.annotation.InsertDefinition;
import com.mybatis.jpa.annotation.UpdateDefinition;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author svili
 **/
@Mapper
@Repository
public interface UserUpdateMapper {

  @InsertDefinition(selective = true)
  int insertSelective(UserEntity user);

  @UpdateDefinition(selective = true, where = " user_id = #{userId}")
  int updateSelectiveById(UserEntity user);
}
