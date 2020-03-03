package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.BuyHistoryMapper;
import com.gem.tradesystem.service.BuyHistorySerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyHistoryServiceImpl implements BuyHistorySerive {
    @Autowired
    private BuyHistoryMapper buyHistoryMapper;
    @Override
    public IPage<Sucai> selectDownLoadByUid(Integer uid, Integer pageIndex, Integer pageSize) {
        Page<Sucai> sucaiPage = new Page<>(pageIndex,pageSize);
        sucaiPage.setRecords(buyHistoryMapper.selectBuyHistoryByUserId(uid,pageIndex,pageSize));
        return sucaiPage;
    }

    @Override
    public Integer selectDownLoadCountByUid(Integer uid) {
        return buyHistoryMapper.selectBuyHistoryCountByUid(uid);
    }
}
