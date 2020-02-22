package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(String password,String telephone,String username){
        userService.insertUser(password,telephone,username);
    return "redirect:/turnToIndex";
    }
    //跳转到注册页面
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String openRegister(){
        return "reg";
    }
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String telephone, String password, Model model, HttpServletRequest request){
        User user = userService.login(telephone, password);
        if (user!=null){
            request.getSession().setAttribute("user",user);
        }
        return "redirect:/turnToIndex";
    }
    //用户中心
    @RequestMapping(value = "/center")
    public String userCenter(){
        return "user_center";
    }
    //注销
    @RequestMapping(value = "/loginOut")
    public String userCenter(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/turnToIndex";
    }

}
