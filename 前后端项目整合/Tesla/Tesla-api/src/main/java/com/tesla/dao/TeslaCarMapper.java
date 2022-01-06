package com.tesla.dao;

import java.util.List;
import com.tesla.entity.TeslaCarExample;
import org.apache.ibatis.annotations.Param;
import com.tesla.entity.TeslaCar;


public interface TeslaCarMapper {
    long countByExample(TeslaCarExample example);

    int deleteByExample(TeslaCarExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(TeslaCar record);

    int insertSelective(TeslaCar record);

    List<TeslaCar> selectByExampleWithBLOBs(TeslaCarExample example);

    List<TeslaCar> selectByExample(TeslaCarExample example);

    TeslaCar selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") TeslaCar record, @Param("example") TeslaCarExample example);

    int updateByExampleWithBLOBs(@Param("record") TeslaCar record, @Param("example") TeslaCarExample example);

    int updateByExample(@Param("record") TeslaCar record, @Param("example") TeslaCarExample example);

    int updateByPrimaryKeySelective(TeslaCar record);

    int updateByPrimaryKeyWithBLOBs(TeslaCar record);

    int updateByPrimaryKey(TeslaCar record);


}
