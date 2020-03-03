package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.ShoppingCartMapper;
import com.gem.tradesystem.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public IPage<Sucai> selectCarByUid(Integer uid, Integer pageIndex, Integer pageSize) {
        Page<Sucai> sucaiPage = new Page<>(pageIndex,pageSize);
        sucaiPage.setRecords(shoppingCartMapper.selectShoppingCarByUserId(uid,pageIndex,pageSize));
        return sucaiPage;
    }

    @Override
    public Integer selectCarCountByUid(Integer uid) {
        return shoppingCartMapper.selectCarCountByUid(uid);
    }
}
