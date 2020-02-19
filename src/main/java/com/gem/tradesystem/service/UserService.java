package com.gem.tradesystem.service;

import com.gem.tradesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void insertUser(String password, String telephone) {
        userMapper.insertUser(password,telephone);
    }

    public void login(String telephone, String password) {
        userMapper.selectUser(telephone,password);
    }
}
