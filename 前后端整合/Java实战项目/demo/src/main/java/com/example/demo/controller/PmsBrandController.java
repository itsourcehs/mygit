package com.example.demo.controller;

import com.example.demo.mbg.model.PmsBrand;
import com.example.demo.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname PmsBrandController
 * @Description TODO
 * @Date 2021/10/13 18:19
 * @Created by 123456
 */

@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    //
    @Autowired
    private PmsBrandService demoService;

    @GetMapping("listAll")
    @ResponseBody
    public List<PmsBrand> getBrandList(){
        return demoService.listAllBrand();
    }

    //根据id查询某一品牌信息
    @GetMapping("/{id}")
    @ResponseBody
    public PmsBrand brand(@PathVariable("id") Long id){
        return demoService.getBrand(id);
    }

}
