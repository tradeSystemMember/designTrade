package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.mapper.UserSettingMapper;
import com.gem.tradesystem.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingServiceImpl implements UserSettingService {
    @Autowired
    private UserSettingMapper userSettingMapper;

    @Override
    public Boolean updateUserById(Integer id, String username, String sex, String avatar) {
        Boolean flag = userSettingMapper.updateUserByid(id,username,sex,avatar);
        return flag;
    }
}
