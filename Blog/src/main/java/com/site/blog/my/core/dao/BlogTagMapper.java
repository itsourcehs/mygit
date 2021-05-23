package com.site.blog.my.core.dao;

import mybatis.generator.model.TbBlogTag;
import mybatis.generator.model.TbBlogTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogTagMapper {
    long countByExample(TbBlogTagExample example);

    int deleteByExample(TbBlogTagExample example);

    int deleteByPrimaryKey(Integer tagId);

    int insert(TbBlogTag record);

    int insertSelective(TbBlogTag record);

    List<TbBlogTag> selectByExample(TbBlogTagExample example);

    TbBlogTag selectByPrimaryKey(Integer tagId);

    TbBlogTag selectByTagName(String tagName);

    int updateByExampleSelective(@Param("record") TbBlogTag record, @Param("example") TbBlogTagExample example);

    int updateByExample(@Param("record") TbBlogTag record, @Param("example") TbBlogTagExample example);

    int updateByPrimaryKeySelective(TbBlogTag record);

    int updateByPrimaryKey(TbBlogTag record);

    int batchInsertBlogTag(List<TbBlogTag> tagList);
}