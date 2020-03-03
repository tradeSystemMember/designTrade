package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.DownHistoryMapper;
import com.gem.tradesystem.service.DownHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownHistoryServiceImpl implements DownHistoryService {
    @Autowired
    private DownHistoryMapper downHistoryMapper;
    @Override
    public IPage<Sucai> selectDownLoadByUid(Integer uid, Integer pageIndex, Integer pageSize) {
        Page<Sucai> sucaiPage = new Page<>(pageIndex,pageSize);
        sucaiPage.setRecords(downHistoryMapper.selectDownByUserId(uid,pageIndex,pageSize));
        return sucaiPage;
    }

    @Override
    public Integer selectDownLoadCountByUid(Integer uid) {
        return downHistoryMapper.selectDownCountByUid(uid);
    }
}
