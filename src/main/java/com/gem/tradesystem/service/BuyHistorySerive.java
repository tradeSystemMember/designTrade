package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

public interface BuyHistorySerive {
    IPage<Sucai> selectDownLoadByUid(Integer uid, Integer pageIndex, Integer pageSize);

    Integer selectDownLoadCountByUid(Integer uid);
}
