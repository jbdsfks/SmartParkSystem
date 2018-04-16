package com.njust.smartparksystem.dao;

import com.njust.smartparksystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public interface UserDao extends JpaRepository<User, Serializable> {
    User findUserByIdAndPassword(String id,String password);
}
