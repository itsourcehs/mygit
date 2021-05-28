package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-27 22:30
 **/
@Controller
@RequestMapping("/admin")
public class ConfigurationController {
    @Resource
    private ConfigService configService;

    @GetMapping("/configurations")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "configurations");
        request.setAttribute("configurations", configService.getAllConfigs()); //待补充
        return "admin/configuration";
    }
}
