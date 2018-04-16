package com.njust.smartparksystem.service;

import com.njust.smartparksystem.domain.User;

public interface UserService {
    String register(User user);
    User login(String id, String user);
}
