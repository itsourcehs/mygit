package mybatis.generator.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mybatis.generator.entity.TeslaCar;
import mybatis.generator.service.teslaService;
import mybatis.generator.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * f8下一步  f9跳出断点
 * @Api 注解用于类上，表示标识这个类是 swagger 的资源。
 * @ApiOperation 注解用于方法，表示一个 http 请求的操作。
 * @ApiParam 注解用于参数上，用来标明参数信息。
 */

@RestController
@Api(value = "特斯拉在线接口文档~")
@RequestMapping("/api")
public class teslaController {

    @Autowired
    @Qualifier("teslaServiceImpl")
    private teslaService service;


    //查询所有car
    @GetMapping("/car/all")
    @ApiOperation(value = "获取所有car列表")
    public JsonResult<List<TeslaCar>> getAll(){
        return new JsonResult<>(service.findAllCar(),"获取数据成功");
    }

    //通过id获得car
    @GetMapping("/car/{id}")
    @ApiOperation(value = "获取car列表")
    public JsonResult<TeslaCar> getCar(@PathVariable("id") Integer id){
        return new JsonResult<>(service.findCarById(id),"获取数据成功");
    }

    //新增car
    @RequestMapping(value = "/carAdd",method = RequestMethod.GET)
    @ApiOperation(value = "新增car信息")
    public JsonResult addCar(){
        /*
        TeslaCar car = new TeslaCar(4,"4","model v","123","657","234");
        service.insertCar(car);
         */
        return new JsonResult<>("0","新增成功");
    }

}
