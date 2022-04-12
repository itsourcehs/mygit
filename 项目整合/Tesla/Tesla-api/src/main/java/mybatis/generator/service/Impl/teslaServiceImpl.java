package mybatis.generator.service.Impl;

import mybatis.generator.dao.TeslaCarMapper;
import mybatis.generator.entity.TeslaCar;
import mybatis.generator.service.teslaService;
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
    public List<TeslaCar> findByPage(Integer pageSize,Integer currentPage) {
        return mapper.findByPage(pageSize,currentPage);
    }

    @Override
    public int insertCar(TeslaCar car) {
        return mapper.insert(car);
    }

}
