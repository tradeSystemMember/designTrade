package com.gem.tradesystem.utils;

import com.gem.tradesystem.config.DownloadProperties;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.service.SucaiService;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class SrcUrl {
    @Autowired
    private SucaiService sucaiService;

    @Autowired
    private DownloadProperties downloadProperties;

    //获取素材中图片路径
    public String getSrcUrl(Sucai sucai) throws UnsupportedEncodingException {
        String url= URLEncoder.encode(sucai.getSave(),"utf-8");
        String[] suffix=url.split("\\.");
        String attname= URLEncoder.encode(sucai.getName(),"utf-8").replace("+","%20");

        String domain=downloadProperties.getDomain();
        String accesskey= downloadProperties.getAccessKey();
        String secretkey= downloadProperties.getSecretKey();

        url=domain+"/"+url;//baseurl

        long expire=86400L;//过期时间 一天
//        String baseurl=domain+"/小兰.jpg?attname=124.jpg";
        Auth auth = Auth.create(accesskey, secretkey);
        String f_url=auth.privateDownloadUrl(url,expire);

        //        sucai.setSave(url);

        return f_url;
    }

}
