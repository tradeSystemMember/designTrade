package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.Sucai;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DownHistoryMapper {
    @Select("select * from sucai where id in (select sucaiid from down where userid = #{uid}) limit #{pageIndex},#{pageSize}")
    List<Sucai> selectDownByUserId(@Param("uid") Integer uid, @Param("pageIndex") Integer pageIndex, @Param("pageSize")Integer pageSize);
    @Select("select count(1) from sucai where id in (select sucaiid from down where userid = #{uid})")
    Integer selectDownCountByUid(Integer uid);
}
