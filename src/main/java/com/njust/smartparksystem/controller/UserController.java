package com.njust.smartparksystem.controller;

import com.njust.smartparksystem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public User getUserByID(){
        User user = new User();
        return user;
    }
}
