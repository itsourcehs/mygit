package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.service.CommentService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.Result;
import com.site.blog.my.core.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: Blog
 * @description: 评论controller
 * @author: Mr.Huang
 * @create: 2021-05-27 09:01
 **/
@Controller
@RequestMapping("/admin")
public class CommentController {
    @Resource
    private CommentService commentService;
    
    
    /**
     * @Description: 评论列表
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/27
     */
    @GetMapping("/comments/list")
    @ResponseBody
    public Result list(@RequestParam Map<String,Object> params){
        if(StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))){
            return ResultGenerator.genFailResult("参数异常!!!");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(commentService.getCommentsPage(pageUtil));
    }

    /**
     * @Description: 所有评论
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/27
     */
    @GetMapping("/comments")
    public String list(HttpServletRequest request){
        request.setAttribute("path","comments");
        return "admin/comment";
    }
}
