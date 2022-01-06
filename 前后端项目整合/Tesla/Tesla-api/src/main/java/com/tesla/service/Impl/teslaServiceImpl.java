package com.tesla.service.Impl;


import com.tesla.dao.TeslaCarMapper;
import com.tesla.entity.TeslaCar;
import com.tesla.service.teslaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private TeslaCarMapper CarMapper;

    @Override
    public TeslaCar findOne() {
        TeslaCar cars = CarMapper.selectByPrimaryKey(1);
        return cars;
    }
}
