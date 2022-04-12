package  mybatis.generator.service;

import mybatis.generator.entity.TeslaCar;
import java.util.List;

public interface teslaService {

    TeslaCar findCarById(Integer id);

    List<TeslaCar> findAllCar();

    List<TeslaCar> findByPage(Integer pageSize,Integer currentPage);

    int insertCar(TeslaCar car);
}
