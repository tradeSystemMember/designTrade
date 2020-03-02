package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.service.SucaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class DownloadController {
    @Autowired
    private SucaiService sucaiService;

    @RequestMapping("/download")
    public String download(Model model, HttpServletRequest request){
        String sid=request.getParameter("id");
        Integer id=Integer.parseInt(sid);
        Sucai sucai=sucaiService.getOneById(id);
        model.addAttribute("sucai",sucai);
        return "down_jifenbuzu_yuezu";
    }

}
