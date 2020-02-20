package com.gem.tradesystem.service;

import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void insertUser(String password, String telephone, String username) {
        Date regTime = new Date();
        userMapper.insertUser(username,password,telephone,regTime);
    }

    public User login(String telephone, String password) {
        User user = userMapper.selectUser(telephone, password);
        if (user!=null){
            return user;
        }
        return null;
    }
}
