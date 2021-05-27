package com.site.blog.my.core.controller.admin;

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
 * @Classname CategoryController
 * @Description TODO
 * @Date 2021/5/27 16:32
 * @Created by 123456
 */
@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Resource
    private CategoryService categoryService;


    @GetMapping("/categories")
    public String categoryPage(HttpServletRequest request){
        request.setAttribute("path","categories");
        return "admin/category";
    }

    @RequestMapping(value = "/categories/list",method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String,Object> params){
        if(StringUtils.isEmpty(params.get("page")) ||
        StringUtils.isEmpty(params.get("limit"))){
            return ResultGenerator.genFailResult("参数异常!!!");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(
                categoryService.getBlogCategoryPage(pageUtil)
        );
    }

    /**
     * @Description 新增分类
     * @Param 分类name 分类icon
     * @return
     * @date 2021/5/27 17:05
     * @auther 123456
     */
    @RequestMapping(value = "/categories/save",method = RequestMethod.POST)
    @ResponseBody /**不写有坑*/
    public Result save(@RequestParam("categoryName")String categoryName
            ,@RequestParam("categoryIcon")String categoryIcon){
        /**对分类名称判空*/
        if(StringUtils.isEmpty(categoryName)){
            return ResultGenerator.genFailResult("请输入分类名称");
        }
        if(StringUtils.isEmpty(categoryIcon)){
            return ResultGenerator.genFailResult("请选择分类图标");
        }
        if(categoryService.saveCategory(categoryName, categoryIcon)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }


    /**
     * @Description 修改分类信息
     * @Param categoryId categoryName categoryIcon
     * @return
     * @date 2021/5/27 18:44
     * @auther 123456
     */
    @RequestMapping(value = "/categories/update",method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("categoryId")Integer categoryId
            ,@RequestParam("categoryName")String categoryName
            ,@RequestParam("categoryIcon")String categoryIcon){
        /**对分类名称判空*/
        if(StringUtils.isEmpty(categoryName)){
            return ResultGenerator.genFailResult("请输入分类名称");
        }
        if(StringUtils.isEmpty(categoryIcon)){
            return ResultGenerator.genFailResult("请选择分类图标");
        }
        if(categoryService.updateCategory(categoryId
                ,categoryName
                ,categoryIcon)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }

}
