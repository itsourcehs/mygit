package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.service.CommentService;
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

    @PostMapping("/comments/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids){
        /**当列表数据大于1时才能删除*/
        if(ids.length < 1){
            return ResultGenerator.genFailResult("参数异常!!!");
        }
        if(commentService.deleteBatch(ids)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("删除失败!!!");
        }
    }
    
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

    @PostMapping("/comments/checkDone")
    @ResponseBody
    public Result checkDone(@RequestBody Integer[] ids){
        /**判断评论列表数据小于1*/
        if(ids.length <1){
            return ResultGenerator.genFailResult("参数异常!!!");
        }
        /***/
        if(commentService.checkDone(ids)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("审核失败!!!");
        }
    }

    @PostMapping("/comments/reply")
    @ResponseBody
    public Result checkDone(@RequestParam("commentId") Long commentId
            ,@RequestParam("replyBody") String replyBody){
        if(commentId == null || commentId <1 ||StringUtils.isEmpty(replyBody)){
            return ResultGenerator.genFailResult("参数异常!!!");
        }
        if(commentService.reply(commentId, replyBody)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("回复失败!!!");
        }

    }

}
