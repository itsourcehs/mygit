package mybatis.generator.dao;

import mybatis.generator.entity.TeslaCar;
import mybatis.generator.entity.TeslaCarExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeslaCarMapper {
    long countByExample(TeslaCarExample example);

    long count();

    int deleteByExample(TeslaCarExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(TeslaCar record);

    int insertSelective(TeslaCar record);

    List<TeslaCar> selectByExample(TeslaCarExample example);

    TeslaCar selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") TeslaCar record, @Param("example") TeslaCarExample example);

    int updateByExample(@Param("record") TeslaCar record, @Param("example") TeslaCarExample example);

    int updateByPrimaryKeySelective(TeslaCar record);

    int updateByPrimaryKey(TeslaCar record);

    List<TeslaCar> findAll();

    List<TeslaCar> findByPage(@Param("currentPage") Integer currentPage,@Param("pageSize") Integer pageSize);
}
