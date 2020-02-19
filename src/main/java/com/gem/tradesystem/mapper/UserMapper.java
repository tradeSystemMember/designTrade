package com.gem.tradesystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user values (null,null,#{password},#{telephone})")
    void insertUser(String password,String telephone);
    @Select("select* from user where telephone=#{telephone} and password=#{password}")
    void selectUser(String telephone, String password);
}
