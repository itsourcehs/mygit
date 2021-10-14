package com.example.demo.controller;

import com.example.demo.dto.UmsAdminParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/login")
    //登录
    public void login(@RequestBody UmsAdminParam umsAdminParam){
        //

    }


}
