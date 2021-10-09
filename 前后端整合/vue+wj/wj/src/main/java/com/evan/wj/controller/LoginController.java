package com.evan.wj.controller;

import com.evan.wj.result.Result;
import com.evan.wj.pojo.User;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Classname LoginController
 * @Description TODO
 * @Date 2021/6/29 15:55
 * @Created by 123456
 */
@Controller
public class LoginController {
    @Resource
    UserService userService;

    @CrossOrigin
    @PostMapping(value="/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        /*// 对html标签转义,防止xss攻击
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());
        User user = userService.get(username, requestUser.getPassword());

        if(null == user){
            return new Result(400);
        }else {
            session.setAttribute("user",user);
            return new Result(200);
        }*/
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, requestUser.getPassword());
        token.setRememberMe(true);
        try {
            subject.login(token);
            return ResultFactory.buildSuccessResult(username);
        }catch (IncorrectCredentialsException e){
            String message = "账号或密码错误";
            return ResultFactory.buildFailResult(message);
        }catch (UnknownAccountException e ){
            return ResultFactory.buildFailResult("账号不存在");
        }
    }

    @CrossOrigin
    @PostMapping("/api/register")
    @ResponseBody
    public Result register(@RequestBody User user){
        //思路: 加盐再2次hash
        String username = user.getUsername();
        String password = user.getPassword();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            String message = "用户名或密码不能为空";
            return ResultFactory.buildFailResult(message);
        }
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        Boolean exist = userService.isExist(username);
        if(exist){
            String mess = "用户名已被使用";
            return ResultFactory.buildFailResult(mess);
        }
        //盐算法,默认长度16位
        String salt = new SecureRandomNumberGenerator()
                .nextBytes().toString();
        //设置 hash 算法迭代次数
        int times = 2;
        //得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5"
                ,password,salt,times)
                .toString();
        //存储用户信息,包括 盐salt 与 hash后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @CrossOrigin
    @GetMapping("/api/logout")
    @ResponseBody
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("成功登出");
    }

    @CrossOrigin
    @GetMapping("/api/authentication")
    @ResponseBody
    public String authentication(){
        return "身份认证成功";
    }
}
