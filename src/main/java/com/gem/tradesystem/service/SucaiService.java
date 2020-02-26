package com.gem.tradesystem.service;


import com.gem.tradesystem.entity.Sucai;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SucaiService {
    Sucai getOneById(Integer id);//根据id获取素材
    Integer getCount();//获取素材总数
    Integer getSubMenuCount(String typename);//获取二级菜单的素材总数
    Integer getMenuCount(String typename);//获取一级菜单的素材总数
    List<String> getMenu();//一级菜单加载
    List<String> getAllSubMenu();//'全部'tab下的二级菜单加载
    List<Sucai> getList();//获取所有素材
    List<String> getSubMenu(String typename);//获取一级菜单下的二级菜单
    List<Sucai> getSubMenuList(String typename);//获取二级菜单下的所有素材
    List<Sucai> getMenuList(String typename);//获取一级菜单下的所有素材
    List<Sucai> getPageList(Integer page,Integer size);//分页获取所有素材
    List<Sucai> getSubMenuPageList(String typename,Integer page,Integer size);//分页获取二级菜单下的所有素材
    List<Sucai> getMenuPageList(String typename,Integer page,Integer size);//分页获取一级菜单下的所有素材
    List<String> getTags(Integer sucaiid);//获取素材的所有标签项
    String getPMenu(String typename);//获取二级菜单的父菜单
    List<Sucai> getSearchList(String search);//获取根据输入的素材名称模糊查询的所有结果
    Integer getSearchCount(String search);//获取搜索结果的素材总数
    List<Sucai> getSearchPageList(String search,Integer page,Integer size);//分页获取搜索结果的素材

//    Sucai getOneSu(Integer id);
    int updateFav(Integer id);//根据sucai的id更新sucai表中的点赞数
    int insertOneFav(Integer sucaiid,Integer userid);
}
