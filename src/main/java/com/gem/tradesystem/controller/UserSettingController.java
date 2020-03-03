package com.gem.tradesystem.controller;

import com.gem.tradesystem.config.UploadProperties;
import com.gem.tradesystem.service.UploadFile;
import com.gem.tradesystem.service.UserSettingService;
import com.gem.tradesystem.service.impl.UploadFileQiniu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/*用户设置*/
@Controller
@RequestMapping("/userSetting")
public class UserSettingController {
    @Autowired
    private UserSettingService userSettingService;
    @Autowired
    UploadProperties uploadProperties;
    @RequestMapping("/toUserSetting")
    public String toUserSetting(){
        return "userSetting";
    }

    //用户设置
    @RequestMapping(value = "/setting",method = RequestMethod.POST)
    public String userSettingById(Integer id, String username, String sex, MultipartFile avatarPic, Model model){
        UploadFile uploadFile = new UploadFileQiniu(uploadProperties.getQiniu());
        String avatar = uploadFile.uploadFile(avatarPic);
        Boolean flag = userSettingService.updateUserById(id,username,sex,avatar);
        model.addAttribute("updateUserStatus",flag);
        return "redirect:/center/toCenter";
    }
}
