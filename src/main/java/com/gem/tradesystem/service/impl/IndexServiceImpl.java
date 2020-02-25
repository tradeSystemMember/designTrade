package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.mapper.IndexMapper;
import com.gem.tradesystem.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;
    @Override
    public User login(String telephone, String password) {
        User user = indexMapper.selectUser(telephone, password);
        if (user!=null){
            return user;
        }
        return null;
    }
}
