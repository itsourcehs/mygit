package com.hs.service.Impl;

import com.hs.dao.TeslaCarMapper;
import com.hs.entity.TeslaCar;
import com.hs.service.teslaService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


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
    public TeslaCar findCarById(Integer id) {
        TeslaCar teslacar = mapper.selectByPrimaryKey(id);
        return teslacar;
    }

    @Override
    public List<TeslaCar> findAllCar() {
        return mapper.findAll();
    }

    @Override
    public List<TeslaCar> findByPage(Integer currentPage,Integer pageSize) {
        return mapper.findByPage(currentPage,pageSize);
    }

    @Override
    public int insertCar(TeslaCar car) {
        return mapper.insert(car);
    }

    @Override
    public long count() {
        return mapper.count();
    }

    @Override
    public int delCar(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

}
