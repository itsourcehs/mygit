package com.hs.controller;

import com.hs.entity.TeslaActivity;
import com.hs.service.teslaActivityService;
import com.hs.utils.JsonResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "特斯拉活动接口文档~")
@RequestMapping("/api")
public class teslaActivityController {

    @Autowired
    @Qualifier("teslaActivityServiceImpl")
    private teslaActivityService service;

    @RequestMapping("/activity/{id}")
    public JsonResult<TeslaActivity> findActivity(@PathVariable("id") String id){
        return new JsonResult<>(service.findActivityById(id),"获取数据成功");
    }

    @GetMapping("/activity/all")
    public JsonResult<List<TeslaActivity>> findAllActivity(){
        return new JsonResult<>(service.findAllActivity(),"获取数据成功.");
    }
}
