package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/7/23 16:05
 * @Created by 123456
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @CrossOrigin
    @GetMapping("/api/admin/user")
    @ResponseBody
    public List<User> listUsers() throws Exception{
        return userService.list();
    }
}
