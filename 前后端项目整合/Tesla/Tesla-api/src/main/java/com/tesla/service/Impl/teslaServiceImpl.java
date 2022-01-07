package com.tesla.service.Impl;


import com.tesla.dao.TeslaCarMapper;
import com.tesla.entity.TeslaCar;
import com.tesla.service.teslaService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 * @Classname teslaServiceImpl
 * @Description TODO
 * @Date 2022/1/5 18:53
 * @Created by 123456
 */

@Service
public class teslaServiceImpl implements teslaService {

    @Resource
    private TeslaCarMapper mapper;

    @Override
    public TeslaCar findAllCars() {
        return null;
    }
}
