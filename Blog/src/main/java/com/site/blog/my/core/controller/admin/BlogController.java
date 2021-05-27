package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.entity.Blog;
import com.site.blog.my.core.service.BlogService;
import com.site.blog.my.core.service.CategoryService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.Result;
import com.site.blog.my.core.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Classname BlogController
 * @Description TODO
 * @Date 2021/5/26 16:43
 * @Created by 123456
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private CategoryService categoryService;

    @GetMapping("/blogs")
    public String list(HttpServletRequest request){
        request.setAttribute("path","blogs");
        return "admin/blog";
    }

    @GetMapping("/blogs/list")
    @ResponseBody
    public Result list(@RequestParam Map<String,Object> params){
        if(StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))){
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(blogService.getBlogsPage(pageUtil));
    }
    /**
     * @Description: 后台发布新博客文章
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/26
     */
    @GetMapping("/blogs/edit")
    public String edit(HttpServletRequest request){
        request.setAttribute("path","edit");
        request.setAttribute("categories",categoryService.getAllCategories());
        return "admin/edit";
    }

    /**
     * @Description: 根据博客文章id进行修改博客
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/26
     */
    @GetMapping("/blogs/edit/{blogId}")
    public String edit(HttpServletRequest request
            , @PathVariable("blogId") Long blogId){
        request.setAttribute("path","edit");
        Blog blog = blogService.getBlogById(blogId);
        if(blog == null){
            return "error/error_400";
        }
        request.setAttribute("blog",blog);
        request.setAttribute("categories",categoryService.getAllCategories());
        return "admin/edit";
    }









}
