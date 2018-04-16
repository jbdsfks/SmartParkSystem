package com.njust.smartparksystem.service.impl;

import com.njust.smartparksystem.dao.UserDao;
import com.njust.smartparksystem.domain.User;
import com.njust.smartparksystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public User register(User user){
        return  userDao.save(user);
    }

    @Override
    public User login(String id, String password){
        User user = userDao.findUserById(id);
        logger.info(user.toString());
        return user;
    }

    @Override
    public User findUserByID(String id){
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public boolean changePWD(String id,String password){
        int result = userDao.changePWD(id,password);
        if (result == 1)
            return true;
        else
            return false;

    }
}
