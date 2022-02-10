package  mybatis.generator.service;

import mybatis.generator.entity.Teslacar;

public interface teslaService {

    Teslacar findCarById();
    int insertCar();
}
