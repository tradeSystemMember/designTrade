package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

public interface DownHistoryService {
    IPage<Sucai> selectDownLoadByUid(Integer uid, Integer pageIndex, Integer pageSize);

    Integer selectDownLoadCountByUid(Integer uid);
}
