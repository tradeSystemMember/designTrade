package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

public interface ShoppingCartService {
    IPage<Sucai> selectCarByUid(Integer uid, Integer pageIndex, Integer pageSize);

    Integer selectCarCountByUid(Integer uid);
}
