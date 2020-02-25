package com.gem.tradesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*用户中心*/
@Controller
@RequestMapping("/center")
public class UserCenterController {
    @RequestMapping("/toCenter")
    public String toCenter(){
        return "user_center";
    }
}
