package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.entity.AdminUser;
import com.site.blog.my.core.service.AdminUserService;
import com.site.blog.my.core.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @Resource
    private AdminUserService adminUserService;

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

    /**
     * @Description 拦截用户名与密码,验证码不能为空
     * @Param
     * @return
     * @date 2021/5/24 12:35
     * @auther 123456
     */
    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName
            , @RequestParam("password") String password
            , @RequestParam("verifyCode") String verifyCode
            , HttpSession session){
        if(StringUtils.isEmpty(verifyCode)) {
            session.setAttribute("errorMsg", "验证码不能为空");
            return "admin/login";
        }
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            session.setAttribute("errorMsg","用户名或密码不能为空");
            return "admin/login";
        }
        String kaptchaCode = session.getAttribute("verifyCode")+"";
        if(StringUtils.isEmpty("verifyCode") || verifyCode.equals(kaptchaCode)){
            session.setAttribute("errorMsg","验证码错误");
            return "admin/login";
        }
        AdminUser adminUser = adminUserService
                .login(userName, password);
        if(adminUser != null){
            session.setAttribute("loginUser",adminUser.getNickName());
            session.setAttribute("loginUserId",adminUser.getAdminUserId());

            return "redirect:/admin/index";
        }else {
            session.setAttribute("errorMsg","登录失败");
            return "admin/login";
        }


    }


}
