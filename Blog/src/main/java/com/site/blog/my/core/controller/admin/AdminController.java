package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-23 23:09
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private BlogService blogService;


    @GetMapping({"/login"})
    public String login(){
        return "admin/login";
    }

    @GetMapping({"","/","/index","/index.html"})
    public String index(HttpServletRequest request){
        request.setAttribute("path","index");

        request.setAttribute("blogCount",blogService.getTotalBlogs());
        return "admin/index";
    }


}
