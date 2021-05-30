package com.site.blog.my.core.dao;

import com.site.blog.my.core.entity.BlogTagRelation;
import mybatis.generator.model.TbBlogTagRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogTagRelationMapper {
    long countByExample(TbBlogTagRelationExample example);

    int deleteByExample(TbBlogTagRelationExample example);

    int deleteByPrimaryKey(Long relationId);

    int insert(BlogTagRelation record);

    int insertSelective(BlogTagRelation record);

    List<BlogTagRelation> selectByExample(TbBlogTagRelationExample example);

    BlogTagRelation selectByPrimaryKey(Long relationId);

    int updateByExampleSelective(@Param("record") BlogTagRelation record, @Param("example") TbBlogTagRelationExample example);

    int updateByExample(@Param("record") BlogTagRelation record, @Param("example") TbBlogTagRelationExample example);

    int updateByPrimaryKeySelective(BlogTagRelation record);

    int updateByPrimaryKey(BlogTagRelation record);

    int batchInsert(@Param("relationList") List<BlogTagRelation> blogTagRelationList);

    List<Long> selectDistinctTagIds(Integer[] tagIds);
}