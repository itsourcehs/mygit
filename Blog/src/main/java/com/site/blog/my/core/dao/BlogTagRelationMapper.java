package com.site.blog.my.core.dao;

import mybatis.generator.model.TbBlogTagRelation;
import mybatis.generator.model.TbBlogTagRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogTagRelationMapper {
    long countByExample(TbBlogTagRelationExample example);

    int deleteByExample(TbBlogTagRelationExample example);

    int deleteByPrimaryKey(Long relationId);

    int insert(TbBlogTagRelation record);

    int insertSelective(TbBlogTagRelation record);

    List<TbBlogTagRelation> selectByExample(TbBlogTagRelationExample example);

    TbBlogTagRelation selectByPrimaryKey(Long relationId);

    int updateByExampleSelective(@Param("record") TbBlogTagRelation record, @Param("example") TbBlogTagRelationExample example);

    int updateByExample(@Param("record") TbBlogTagRelation record, @Param("example") TbBlogTagRelationExample example);

    int updateByPrimaryKeySelective(TbBlogTagRelation record);

    int updateByPrimaryKey(TbBlogTagRelation record);

    int batchInsert(@Param("relationList") List<TbBlogTagRelation> blogTagRelationList);
}