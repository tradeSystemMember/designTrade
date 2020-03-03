package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.Sucai;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyHistoryMapper {
    @Select("select * from sucai where id in (select sucaiid from  `order` where userid = #{uid}) limit #{pageIndex},#{pageSize}")
    List<Sucai> selectBuyHistoryByUserId(@Param("uid") Integer uid, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
    @Select("select count(1) from sucai where id in (select sucaiid from `order` where userid = #{uid})")
    Integer selectBuyHistoryCountByUid(Integer uid);
}
