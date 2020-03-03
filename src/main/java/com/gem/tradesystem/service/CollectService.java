package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

public interface CollectService {
    IPage<Sucai> selectFavByUid(Integer uid, Integer pageIndex, Integer pageSize);

    Integer selectFavCountByUid(Integer uid);
}
