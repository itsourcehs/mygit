package com.site.blog.my.core.dao;

import mybatis.generator.model.TbLink;
import mybatis.generator.model.TbLinkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogLinkMapper {
    long countByExample(TbLinkExample example);

    int deleteByExample(TbLinkExample example);

    int deleteByPrimaryKey(Integer linkId);

    int insert(TbLink record);

    int insertSelective(TbLink record);

    List<TbLink> selectByExample(TbLinkExample example);

    TbLink selectByPrimaryKey(Integer linkId);

    int updateByExampleSelective(@Param("record") TbLink record, @Param("example") TbLinkExample example);

    int updateByExample(@Param("record") TbLink record, @Param("example") TbLinkExample example);

    int updateByPrimaryKeySelective(TbLink record);

    int updateByPrimaryKey(TbLink record);
}