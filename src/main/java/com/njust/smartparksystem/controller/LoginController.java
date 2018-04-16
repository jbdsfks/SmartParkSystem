package com.njust.smartparksystem.controller;

import com.njust.smartparksystem.domain.LearnResouce;
import com.njust.smartparksystem.domain.User;
import com.njust.smartparksystem.service.UserService;
import com.njust.smartparksystem.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        if(!id.equals("") && password!=""){
            logger.info(id);
            logger.info(password);
            UserService userService = new UserServiceImpl();
            User user = userService.login(id,password);
            if (user.getId()!=null){
                request.getSession().setAttribute("user",user);
                map.put("result","200");
                map.put("msg","登录成功！");
                map.put("user_id",user.getId());
                map.put("user_name",user.getName());
            }
            else{
                map.put("result","404");
                map.put("msg","用户不存在或密码错误");
            }
        }else{
            map.put("result","304");
        }
        return map;
    }

    @RequestMapping("/toLogin")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }
}
