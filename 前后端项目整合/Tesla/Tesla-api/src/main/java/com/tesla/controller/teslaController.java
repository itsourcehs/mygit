package com.tesla.controller;

import com.tesla.entity.TeslaCar;
import com.tesla.service.teslaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 */

@Controller
public class teslaController {

//    private teslaService service;

    @GetMapping("/hello")
    @ResponseBody
    public TeslaCar getCar(){
//        return service.findOne();
        return null;
    }
}
