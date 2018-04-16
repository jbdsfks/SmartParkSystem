package com.njust.smartparksystem.service.impl;

import com.njust.smartparksystem.dao.UserDao;
import com.njust.smartparksystem.domain.User;
import com.njust.smartparksystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public String register(User user){
        return "success";
    }

    @Override
    public User login(String id, String password){
        User user = userDao.findUserByIdAndPassword(id,password);
        logger.info(user.toString());
        return user;
    }
}
