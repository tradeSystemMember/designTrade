package com.gem.tradesystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserSettingMapper {
    //设置用户信息,包括头像
    @Update("update user set username=#{username},sex=#{sex},avatar=#{avatar} where id = #{id}")
    Boolean updateUserByid(Integer id, String username, String sex, String avatar);
}
