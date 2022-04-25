package com.hs.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.hs.entity.TeslaCar;
import com.hs.service.teslaService;
import com.hs.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 * f8下一步  f9跳出断点
 * @Api 注解用于类上，表示标识这个类是 swagger 的资源。
 * @ApiOperation 注解用于方法，表示一个 http 请求的操作。
 * @ApiParam 注解用于参数上，用来标明参数信息。
 */
@Slf4j
@RestController
@Api(value = "特斯拉在线接口文档~")
@RequestMapping("/api")
public class teslaController {

    @Autowired
    @Qualifier("teslaServiceImpl")
    private teslaService service;


    @GetMapping("/car/del/{carId}")
    @ApiOperation(value = "根据carId删除car")
    public JsonResult delCar(@PathVariable("carId") Integer carId){
        service.delCar(carId);
        return new JsonResult<>("0","删除成功");
    }


    @RequestMapping("/cars/count")
    @ApiOperation(value = "统计所有car记录数")
    public long countCars(){
        return service.count();
    }


    @RequestMapping("/cars/{pageSize}/{currentPage}")
    @ApiOperation(value = "根据当前页查询数据")
    public JsonResult<List<TeslaCar>> findCarsByPage(@PathVariable("pageSize") Integer pageSize,@PathVariable("currentPage") Integer currentPage){
        log.info("[api/cars/"+pageSize+"/"+currentPage+"]");
        Integer current = (currentPage - 1)*pageSize;
        return new JsonResult<>( service.findByPage(current,pageSize),"获取数据成功");
    }


    @GetMapping("/car/all")
    @ApiOperation(value = "获取所有car列表")
    public JsonResult<List<TeslaCar>> findAll(){
        return new JsonResult<>(service.findAllCar(),"获取数据成功");
    }


    @GetMapping("/car/{id}")
    @ApiOperation(value = "获取car列表")
    public JsonResult<TeslaCar> findCar(@PathVariable("id") Integer id){
        return new JsonResult<>(service.findCarById(id),"获取数据成功");
    }

    //新增car
    @RequestMapping(value = "/carAdd")
    @ApiOperation(value = "新增car信息")
    public JsonResult addCar(@RequestBody TeslaCar car){
        service.insertCar(car);
        return new JsonResult<>("0","新增成功");
    }


    @RequestMapping(value = "/covers")
    @ApiOperation(value = "返回 car 图片地址")
    public String coversUpload(MultipartFile file) throws Exception {
        File imageFolder = new File("D:/workspace/img");
        //获取的是文件的完整名称，包括文件名称+文件拓展名
        String f1 = file.getOriginalFilename();
        String str = StringUtils.getRandomString(6);
        File f = new File(imageFolder, str +
                f1.substring(f1.length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8081/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
