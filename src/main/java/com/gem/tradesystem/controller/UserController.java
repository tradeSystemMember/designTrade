package com.gem.tradesystem.controller;

import com.gem.tradesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(String password,String telephone,Model model){
        userService.insertUser(password,telephone);
    return "index";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String openRegister(){
        return "reg";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String telephone,String password){
        userService.login(telephone,password);
        return "index";
    }
}
