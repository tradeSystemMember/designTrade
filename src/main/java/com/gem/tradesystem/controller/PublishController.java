package com.gem.tradesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/publish")
public class PublishController {
    @RequestMapping("/toPublish")
    public String toPublish(){
        return "publish";
    }

}
