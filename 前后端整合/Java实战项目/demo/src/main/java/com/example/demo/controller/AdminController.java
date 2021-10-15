package com.example.demo.controller;

import com.example.demo.dto.UmsAdminParam;
import org.springframework.web.bind.annotation.*;

/**
 *
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/login")
    @ResponseBody
    //登录
    public String login(@RequestBody UmsAdminParam umsAdminParam){
        return "1";

    }


}
