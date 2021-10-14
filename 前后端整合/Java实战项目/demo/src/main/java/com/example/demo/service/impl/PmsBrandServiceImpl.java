package com.example.demo.service.impl;

import com.example.demo.mbg.mapper.PmsBrandMapper;
import com.example.demo.mbg.model.PmsBrand;
import com.example.demo.mbg.model.PmsBrandExample;
import com.example.demo.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname PmsBrandServiceImpl
 * @Description 品牌接口实现类
 * @Date 2021/10/13 18:31
 * @Created by 123456
 */
@Component
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    private PmsBrandMapper brandMapper;

    @Override
    public int createBrand(PmsBrand brand) {
        return 0;
    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        return 0;
    }

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        return null;
    }
}
