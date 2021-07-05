package com.evan.wj.controller;

import com.evan.wj.pojo.Result;
import com.evan.wj.pojo.User;
import com.evan.wj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

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
    public Result login(@RequestBody User requestUser, HttpSession session){
        // 对html标签转义,防止xss攻击
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());
        User user = userService.get(username, requestUser.getPassword());

        if(null == user){
            return new Result(400);
        }else {
            session.setAttribute("user",user);
            return new Result(200);
        }
    }
}
