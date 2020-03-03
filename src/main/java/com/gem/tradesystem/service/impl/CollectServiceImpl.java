package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.CollectMapper;
import com.gem.tradesystem.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl implements CollectService{
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public IPage<Sucai> selectFavByUid(Integer uid, Integer pageIndex, Integer pageSize) {
        Page<Sucai> sucaiPage = new Page<>(pageIndex,pageSize);
        sucaiPage.setRecords(collectMapper.selectFavByUid(uid,pageIndex,pageSize));
        return sucaiPage;
    }

    @Override
    public Integer selectFavCountByUid(Integer uid) {
        return collectMapper.selectFavCountByUid(uid);
    }
}
