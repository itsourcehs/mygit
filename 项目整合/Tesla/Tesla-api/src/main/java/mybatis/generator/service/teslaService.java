package  mybatis.generator.service;

import mybatis.generator.entity.TeslaCar;

import java.util.List;

public interface teslaService {

    TeslaCar findCarById(Integer id);

    List<TeslaCar> findAllCar();

    int insertCar(TeslaCar car);
}
