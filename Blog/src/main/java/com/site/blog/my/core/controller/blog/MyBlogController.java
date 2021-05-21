package com.site.blog.my.core.controller.blog;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-19 17:30
 **/

@Controller
public class MyBlogController {
    /**
     * 首页
     */
    @GetMapping({"/","/index","index.html"})
    public String index(HttpRequest request){
        return
    }

}
