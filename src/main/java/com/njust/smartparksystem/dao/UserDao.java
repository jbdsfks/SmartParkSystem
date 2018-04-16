package com.njust.smartparksystem.dao;

import com.njust.smartparksystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

}
