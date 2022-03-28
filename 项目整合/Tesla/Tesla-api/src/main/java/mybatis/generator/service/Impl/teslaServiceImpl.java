package mybatis.generator.service.Impl;

import mybatis.generator.dao.TeslacarMapper;
import mybatis.generator.entity.Teslacar;
import mybatis.generator.service.teslaService;
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
    private TeslacarMapper testmapper;

    @Override
    public Teslacar findCarById() {
        Teslacar teslacar = testmapper.selectByPrimaryKey(1);
        return teslacar;
    }

    @Override
    public int insertCar() {
        Teslacar teslacar = new Teslacar(2,"","2","2");
        return testmapper.insert(teslacar);
    }

}
