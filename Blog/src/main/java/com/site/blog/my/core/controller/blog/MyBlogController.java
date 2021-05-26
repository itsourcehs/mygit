package com.site.blog.my.core.controller.blog;

import com.site.blog.my.core.service.BlogService;
import com.site.blog.my.core.service.ConfigService;
import com.site.blog.my.core.service.TagService;
import com.site.blog.my.core.util.PageResult;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-19 17:30
 **/

@Controller
//@RequestMapping("") /***/
public class MyBlogController {
    public static String theme = "amaze";
    @Resource
    private BlogService blogService;

    @Resource
    private TagService tagService;

    @Resource
    private ConfigService configService;
    /**
     * 首页
     */
    @GetMapping({"/","/index","index.html"})
    public String index(HttpServletRequest request){
        return this.page(request,1);
    }

    /**
     * @Description: 首页分页数据
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    @GetMapping({"/page/{pageNum}"})
    public String page(HttpServletRequest request, @PathVariable("pageNum") int pageNum){
        PageResult blogPageResult = blogService.getBlogsForIndexPage(pageNum);
        if(blogPageResult == null){
            return "error/error_404";
        }
       request.setAttribute("blogPageResult",blogPageResult);
       request.setAttribute("newBlogs",blogService.getBlogListForIndexPage(1));
       request.setAttribute("hotBlogs",blogService.getBlogListForIndexPage(0));
       request.setAttribute("hotTags",tagService.getBlogTagCountForIndex());
       request.setAttribute("pageName","首页");
       request.setAttribute("configurations",configService.getAllConfigs());

       return "blog/" + theme + "/index";
    }
}
