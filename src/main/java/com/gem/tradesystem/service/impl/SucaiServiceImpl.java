package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.SucaiMapper;
import com.gem.tradesystem.service.SucaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucaiServiceImpl implements SucaiService {
    @Autowired
    private SucaiMapper sucaiMapper;

    @Override
    public Integer getCount() {
        Integer count=sucaiMapper.getCount();
        return count;
    }

    @Override
    public Integer getSubMenuCount(String typename) {
        Integer count=sucaiMapper.getSubMenuCount(typename);
        return count;
    }

    @Override
    public Integer getMenuCount(String typename) {
        Integer count=sucaiMapper.getMenuCount(typename);
        return count;
    }

    @Override
    public List<String> getMenu() {
        List<String> typelist= sucaiMapper.getMenu();
//        typelist.forEach(System.out::println);
        return typelist;
    }

    @Override
    public List<String> getAllSubMenu() {
        List<String> typelist= sucaiMapper.getAllSubMenu();
        return typelist;
    }

    @Override
    public List<Sucai> getList() {
        List<Sucai> list=sucaiMapper.getList();
        return list;
    }

    @Override
    public List<String> getSubMenu(String typename) {
        List<String> typelist= sucaiMapper.getSubMenu(typename);
        return typelist;
    }

    @Override
    public List<Sucai> getSubMenuList(String typename) {
        List<Sucai> slist=sucaiMapper.getSubMenuList(typename);
        return slist;
    }

    @Override
    public List<Sucai> getMenuList(String typename) {
        List<Sucai> slist=sucaiMapper.getMenuList(typename);
        return slist;
    }

    @Override
    public List<Sucai> getPageList(Integer page, Integer size) {
        List<Sucai> slist=sucaiMapper.getPageList(page,size);
        return slist;
    }

    @Override
    public List<Sucai> getSubMenuPageList(String typename, Integer page, Integer size) {
        List<Sucai> slist=sucaiMapper.getSubMenuPageList(typename,page,size);
        return slist;
    }

    @Override
    public List<Sucai> getMenuPageList(String typename, Integer page, Integer size) {
        List<Sucai> slist=sucaiMapper.getMenuPageList(typename,page,size);
        return slist;
    }


}
