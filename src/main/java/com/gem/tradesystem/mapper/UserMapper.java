package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface UserMapper {
    @Insert("insert into user values (null,#{username},#{password},#{telephone},null,#{regTime})")
    void insertUser(String username, String password, String telephone, Date regTime);
    @Select("select* from user where telephone=#{telephone} and password=#{password}")
    User selectUser(String telephone, String password);
}
