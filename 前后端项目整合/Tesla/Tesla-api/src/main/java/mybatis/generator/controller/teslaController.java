package mybatis.generator.controller;


import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mybatis.generator.entity.Teslacar;
import mybatis.generator.service.teslaService;
import mybatis.generator.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @Api 注解用于类上，表示标识这个类是 swagger 的资源。
 * @ApiOperation 注解用于方法，表示一个 http 请求的操作。
 * @ApiParam 注解用于参数上，用来标明参数信息。
 */

@RestController
@Api(value = "特斯拉在线接口文档~")
public class teslaController {

    @Autowired
    @Qualifier("teslaServiceImpl")
    private teslaService testservice;

    //通过id获得car
    @GetMapping("/hello")
    public String getString(){
        String jsonString = JSON.toJSONString(testservice.findCarById());
        return jsonString;
    }

    //获得car信息返回json处理
    @GetMapping("/car")
    public JsonResult<Teslacar> getCar(){
        Teslacar teslacar = new Teslacar(2,"2","2","2");
        return new JsonResult<>(teslacar);
    }

    //获得car信息返回json处理
    @GetMapping("/list")
    public JsonResult<List> getCarList(){
        Teslacar car1 = new Teslacar(3,"3","3",null);
        Teslacar car2 = new Teslacar(4,"4",null,"4");
        List<Teslacar> carList = new ArrayList<>();
        carList.add(car1);carList.add(car2);
        return new JsonResult<>(carList,"获得car列表成功");
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "通过id获得car信息")
    public JsonResult<Teslacar> getCarInfo(@PathVariable @ApiParam(value = "car的唯一id") Integer id){
        Teslacar teslacar = new Teslacar(id,"5","5","5");
        return new JsonResult<>(teslacar);
    }

    @GetMapping("/insert")
    @ApiOperation(value = "添加car信息")
    public int addCar(){
        return testservice.insertCar();
    }
	
	@GetMapping("/delete")
    @ApiOperation(value = "删除car信息")
    public int deleteCar(){
        return null;
    }
}
