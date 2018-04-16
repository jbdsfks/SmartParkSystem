package com.njust.smartparksystem.service;

import com.njust.smartparksystem.domain.User;

public interface UserService {
    User register(User user);
    User login(String id, String user);
    boolean changePWD(String id, String password);
    User findUserByID(String id);
}
