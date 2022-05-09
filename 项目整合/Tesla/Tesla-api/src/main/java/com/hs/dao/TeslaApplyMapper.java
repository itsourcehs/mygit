package com.hs.dao;

import com.hs.entity.TeslaApply;
import com.hs.entity.TeslaApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeslaApplyMapper {
    long countByExample(TeslaApplyExample example);

    int deleteByExample(TeslaApplyExample example);

    int deleteByPrimaryKey(Integer applyId);

    int insert(TeslaApply record);

    int insertSelective(TeslaApply record);

    List<TeslaApply> selectByExample(TeslaApplyExample example);

    TeslaApply selectByPrimaryKey(Integer applyId);

    int updateByExampleSelective(@Param("record") TeslaApply record, @Param("example") TeslaApplyExample example);

    int updateByExample(@Param("record") TeslaApply record, @Param("example") TeslaApplyExample example);

    int updateByPrimaryKeySelective(TeslaApply record);

    int updateByPrimaryKey(TeslaApply record);
}