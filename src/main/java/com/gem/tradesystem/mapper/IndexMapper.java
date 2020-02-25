package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IndexMapper {
    @Select("select* from user where telephone=#{telephone} and password=#{password}")
    User selectUser(String telephone, String password);

}
