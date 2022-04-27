package com.hs.service.Impl;

import com.hs.dao.TeslaActivityMapper;
import com.hs.entity.TeslaActivity;
import com.hs.service.teslaActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: Tesla-api
 * @description:
 * @author: Mr.Huang
 * @create: 2022-04-27 09:05
 **/

@Service
public class teslaActivityServiceImpl implements teslaActivityService {
    @Resource
    private TeslaActivityMapper teslaActivityMapper;

    @Override
    public List<TeslaActivity> findAllActivity() {
        return teslaActivityMapper.findAllActivity();
    }

    @Override
    public TeslaActivity findActivityById(String id) {
        return teslaActivityMapper.selectByPrimaryKey(id);
    }
}
