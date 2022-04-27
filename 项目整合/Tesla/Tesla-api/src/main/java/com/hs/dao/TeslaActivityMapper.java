package com.hs.dao;

import com.hs.entity.TeslaActivity;
import com.hs.entity.TeslaActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeslaActivityMapper {
    long countByExample(TeslaActivityExample example);

    int deleteByExample(TeslaActivityExample example);

    int deleteByPrimaryKey(String id);

    int insert(TeslaActivity record);

    int insertSelective(TeslaActivity record);

    List<TeslaActivity> selectByExample(TeslaActivityExample example);

    List<TeslaActivity> findAllActivity();

    TeslaActivity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TeslaActivity record, @Param("example") TeslaActivityExample example);

    int updateByExample(@Param("record") TeslaActivity record, @Param("example") TeslaActivityExample example);

    int updateByPrimaryKeySelective(TeslaActivity record);

    int updateByPrimaryKey(TeslaActivity record);
}