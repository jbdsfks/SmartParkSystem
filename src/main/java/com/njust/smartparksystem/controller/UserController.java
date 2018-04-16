package com.njust.smartparksystem.controller;

import com.njust.smartparksystem.domain.User;
import com.njust.smartparksystem.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(value = "id") String id,
                                    @RequestParam(value = "password") String password,
                                    @RequestParam(value = "type") String type,
                                    HttpServletRequest request){
        Map<String,Object> map =new HashMap<String,Object>();
        if(!id.equals("") && !password.equals("")){
//            logger.info(id);
//            logger.info(password);
            User user = userService.login(id,password);
            if (user.getId()!=null){
//                logger.info(user.getPassword());
                if (user.getPassword().equals(password)&&user.getType().intValue()==Integer.valueOf(type)){
                    request.getSession().setAttribute("user",user);
                    map.put("result","200");
                    map.put("msg","登录成功！");
                    map.put("user_id",user.getId());
                    map.put("user_name",user.getName());
                }
                else {
                    map.put("result","201");
                    map.put("msg","密码错误！");
                }
            }
            else{
                map.put("result","404");
                map.put("msg","用户不存在");
            }
        }else{
            map.put("result","304");
            map.put("msg","请完整输入！");
        }
        return map;
    }

    @RequestMapping("/toLogin")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login.html");
        return modelAndView;
    }

    @PostMapping("/register")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(value = "id") String id,
                                    @RequestParam(value = "password") String password,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "type") String type,
                                    @RequestParam(value = "phone") String phone,
                                    HttpServletRequest request){
        Map<String,Object> map =new HashMap<String,Object>();
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setType(Integer.valueOf(type));
        user.setPassword(password);
        user.setPhone(phone);
        user.setMoney(BigDecimal.ZERO);

        User the_user = userService.register(user);

        if (the_user != null && !the_user.getId().equals("")){
            map.put("result","200");
            map.put("msg","注册成功！");
            map.put("user_id",user.getId());
            map.put("user_name",user.getName());
        }else {
            map.put("result","201");
            map.put("msg","error！");
        }
        return map;
    }

    @RequestMapping("/toRegister")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("/register.html");
        return modelAndView;
    }

    @PostMapping("/changePWD")
    @ResponseBody
    public Map<String,Object> changePWD(@RequestParam(value = "id") String id,
                                    @RequestParam(value = "oldpwd") String oldpwd,
                                    @RequestParam(value = "newpwd") String newpwd,
                                    HttpServletRequest request){
        Map<String,Object> map =new HashMap<String,Object>();

        User oldUser = userService.findUserByID(id);
        if (oldUser.getPassword().equals(oldpwd)){
            if (oldUser.getPassword().equals(newpwd)){
                map.put("result","201");
                map.put("msg","新密码与旧密码一致！");
            }else {
                if (userService.changePWD(oldUser.getId(), newpwd)){
                    map.put("result","200");
                    map.put("msg","修改成功");
                }else {
                    map.put("result","400");
                    map.put("msg","服务器错误，修改失败，请重试！");
                }
            }
        }else {
            map.put("result","202");
            map.put("msg","旧密码错误！");
        }

        return map;
    }

    @RequestMapping("/toChangePWD")
    public ModelAndView modify(){
        ModelAndView modelAndView = new ModelAndView("/changePWD.html");
        return modelAndView;
    }

    @PostMapping("/userInfo")
    @ResponseBody
    public Map<String,Object> getUserInfoByID(@RequestParam(value = "id") String id,
                                              HttpServletRequest request){
        Map<String,Object> map =new HashMap<String,Object>();
        User user = userService.findUserByID(id);
        request.getSession().setAttribute("user",user);
        map.put("result","200");
        map.put("msg","获取成功！");
        map.put("data",user.toString());
        return map;
    }

    @RequestMapping("/toUserInfo")
    public ModelAndView userInfo(){
        return new ModelAndView("/userInfo.html");
    }
}
