package mybatis.generator.dao;

import java.util.List;
import mybatis.generator.entity.Teslacar;
import mybatis.generator.entity.TeslacarExample;
import org.apache.ibatis.annotations.Param;

public interface TeslacarMapper {
    long countByExample(TeslacarExample example);

    int deleteByExample(TeslacarExample example);

    int deleteByPrimaryKey(Integer carid);

    int insert(Teslacar record);

    int insertSelective(Teslacar record);

    List<Teslacar> selectByExampleWithBLOBs(TeslacarExample example);

    List<Teslacar> selectByExample(TeslacarExample example);

    Teslacar selectByPrimaryKey(Integer carid);

    int updateByExampleSelective(@Param("record") Teslacar record, @Param("example") TeslacarExample example);

    int updateByExampleWithBLOBs(@Param("record") Teslacar record, @Param("example") TeslacarExample example);

    int updateByExample(@Param("record") Teslacar record, @Param("example") TeslacarExample example);

    int updateByPrimaryKeySelective(Teslacar record);

    int updateByPrimaryKeyWithBLOBs(Teslacar record);

    int updateByPrimaryKey(Teslacar record);
}