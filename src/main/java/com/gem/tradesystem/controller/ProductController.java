package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.SucaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/product")

public class ProductController {

    @Autowired
    private SucaiService sucaiService;

    @RequestMapping("/detail")
    public String detail(Integer id,HttpServletRequest request,Model model){
//        String sid=request.getParameter("id");
        if(id!=null){
//            Integer id=Integer.parseInt(sid);
            Sucai sucai=sucaiService.getOneById(id);
//            System.out.println(sucai);
            List<String> taglist=sucaiService.getTags(id);
            model.addAttribute("sucai",sucai);
            model.addAttribute("taglist",taglist);
        }

        return "pro_detail";
    }

    @RequestMapping("/list")//显示pro_list.html
    public String list(Integer curr, HttpServletRequest request, Model model,HttpSession session){
        //页码
        Integer current=1;
        if(curr!=null)
        current=curr;

        Integer pageSize=2;//每页显示数目
        Integer index=(current-1)*pageSize;

        Integer count=sucaiService.getCount();//默认显示所有素材，总数

        List<String> menus= sucaiService.getMenu();
        List<String> submenu=sucaiService.getAllSubMenu();

        List<Sucai> list=sucaiService.getPageList(index,pageSize);//获取显示列表

        String menu=request.getParameter("menu");
        if(menu!=null&&!("".equals(menu))){
            if("全部".equals(menu)){
                //所有素材都显示
            }else{//否则显示相应的menu下的素材
                submenu=sucaiService.getSubMenu(menu);
                count=sucaiService.getMenuCount(menu);
                list=sucaiService.getMenuPageList(menu,index,pageSize);
            }
            model.addAttribute("menu_active",menu);
        }else{
            model.addAttribute("menu_active","全部");
        }

        String submenuname=request.getParameter("submenu");
        if(submenuname!=null&&!("".equals(submenuname))){
            list=sucaiService.getSubMenuPageList(submenuname,index,pageSize);
            count=sucaiService.getSubMenuCount(submenuname);
            model.addAttribute("submenu_active",submenuname);
        }

        //搜索结果
        String search=request.getParameter("search");
        if(search!=null){
            list=sucaiService.getSearchPageList(search,index,pageSize);
            count=sucaiService.getSearchCount(search);
        }

        Integer pageNum=((count-1)/pageSize)+1;//总页数

        model.addAttribute("menus",menus);
        model.addAttribute("submenus",submenu);
        model.addAttribute("list",list);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("curr",current);
        model.addAttribute("total",count);
        model.addAttribute("search",search);

        //尝试进行点赞操作，暂时写死用户
//        if(session.getAttribute("user")==null)
//        {
//            User user=new User();
//            user.setUsername("xzz");
//            session.setAttribute("user",user);
//        }
//        else{
//            System.out.println(session.getAttribute("user"));
//        }


        return "pro_list";
    }

    @RequestMapping("/taglist")//处理异步请求获取素材的标签
    @ResponseBody
    public List<String> taglist(HttpServletRequest request){
        String sid=request.getParameter("sid");
        Integer id=Integer.parseInt(sid);
        List<String> taglist= sucaiService.getTags(id);
        return taglist;
    }

    @RequestMapping("/addfav")//处理点赞
    @ResponseBody
    public String addfav(HttpSession session, HttpServletRequest request) throws IOException {
        System.out.println("进入了controller");
        Integer id=Integer.parseInt(request.getParameter("sid"));
        String str="sid="+id+"user"+ session.getAttribute("user");
        return str;
    }

//    @RequestMapping("/sublist")
//    @ResponseBody
//    public List<String> sublist(HttpServletRequest request,Model model){
////        List<String> menus= sucaiService.getMenu();
//        List<String> submenu=sucaiService.getAllSubMenu();
//        System.out.println(request.getParameter("menu"));
//        if(request.getParameter("menu")!=null&&!("".equals(request.getParameter("menu")))){
//            if("全部".equals(request.getParameter("menu"))){
//                submenu= sucaiService.getAllSubMenu();
//                List<Sucai> list=sucaiService.getList();
//                model.addAttribute("list",list);
//            }else{
//                submenu=sucaiService.getSubMenu(request.getParameter("menu"));
//                List<Sucai> list=sucaiService.getMenuList(request.getParameter("menu"));
//                model.addAttribute("list",list);
//            }
//        }
//        return submenu;
//    }


}
