package com.njust.smartparksystem.service.impl;

import com.njust.smartparksystem.dao.UserDao;
import com.njust.smartparksystem.domain.User;
import com.njust.smartparksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String register(User user){

        return "success";
    }
}
