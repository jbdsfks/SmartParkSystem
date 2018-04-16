package com.njust.smartparksystem.dao;

import com.njust.smartparksystem.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="user")
@Qualifier("userDao")
public interface UserDao extends CrudRepository<User,Long>{

    // 用户登录
    public User findUserById(String id);

    //用户注册
    public User save(User user);

    //更新资料
    @Modifying
    @Query("update User u set u.password=:password where u.id=:id")
    public int changePWD(@Param("id") String id, @Param("password") String password);
}
