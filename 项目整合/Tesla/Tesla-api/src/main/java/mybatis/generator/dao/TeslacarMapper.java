package mybatis.generator.dao;

import java.util.List;
import mybatis.generator.entity.TeslaCar;
import mybatis.generator.entity.TeslaCarExample;
import org.apache.ibatis.annotations.Param;

public interface TeslaCarMapper {
    long countByExample(TeslaCarExample example);

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

    List<TeslaCar> findByPage(Integer pageSize,Integer currentPage);
}
