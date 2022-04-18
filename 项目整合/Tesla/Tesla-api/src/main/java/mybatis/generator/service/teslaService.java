package  mybatis.generator.service;

import mybatis.generator.entity.TeslaCar;
import java.util.List;

public interface teslaService {

    TeslaCar findCarById(Integer id);

    List<TeslaCar> findAllCar();

    List<TeslaCar> findByPage(Integer currentPage,Integer pageSize);

    int insertCar(TeslaCar car);

    long count();

    int delCar(Integer id);
}
