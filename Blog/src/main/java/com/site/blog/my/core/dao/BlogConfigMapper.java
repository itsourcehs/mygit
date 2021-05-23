package com.site.blog.my.core.dao;

import mybatis.generator.model.TbConfig;
import mybatis.generator.model.TbConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogConfigMapper {
    long countByExample(TbConfigExample example);

    int deleteByExample(TbConfigExample example);

    int deleteByPrimaryKey(String configName);

    int insert(TbConfig record);

    int insertSelective(TbConfig record);

    List<TbConfig> selectByExample(TbConfigExample example);

    TbConfig selectByPrimaryKey(String configName);

    int updateByExampleSelective(@Param("record") TbConfig record, @Param("example") TbConfigExample example);

    int updateByExample(@Param("record") TbConfig record, @Param("example") TbConfigExample example);

    int updateByPrimaryKeySelective(TbConfig record);

    int updateByPrimaryKey(TbConfig record);
}