package com.gem.tradesystem.service;


import com.gem.tradesystem.entity.Sucai;

import java.util.List;


public interface SucaiService {
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
}
