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

    @RequestMapping("/cars/count")
    @ApiOperation(value = "统计所有car记录数")
    public long countCars(){
        return service.count();
    }


    @RequestMapping("/cars/{pageSize}/{currentPage}")
    @ApiOperation(value = "根据当前页查询数据")
    public JsonResult<List<TeslaCar>> findCarsByPage(@PathVariable("pageSize") Integer pageSize,@PathVariable("currentPage") Integer currentPage){
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
