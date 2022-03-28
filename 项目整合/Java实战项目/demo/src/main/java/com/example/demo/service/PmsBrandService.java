package com.example.demo.service;

import com.example.demo.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PmsBrandService {

    //增加品牌信息
    int createBrand(PmsBrand brand);
    //删除品牌信息
    int deleteBrand(Long id);
    //修改品牌信息
    int updateBrand(Long id, PmsBrand brand);
    //查询所有品牌信息
    List<PmsBrand> listAllBrand();
    //根据id查询某一品牌信息
    PmsBrand getBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);
}
