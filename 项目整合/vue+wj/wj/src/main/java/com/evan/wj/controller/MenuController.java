package com.evan.wj.controller;

import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname MenuController
 * @Description TODO
 * @Date 2021/7/21 14:13
 * @Created by 123456
 */
@Controller
public class MenuController {
    @Resource
    AdminMenuService adminMenuService;

    @CrossOrigin
    @GetMapping("/api/menu")
    @ResponseBody
    public List<AdminMenu> menus() {
        return adminMenuService.getMenusByCurrentUser();
    }
}
