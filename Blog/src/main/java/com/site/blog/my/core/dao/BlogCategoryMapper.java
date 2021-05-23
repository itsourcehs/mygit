package com.site.blog.my.core.dao;

import mybatis.generator.model.TbBlogCategory;
import mybatis.generator.model.TbBlogCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BlogCategoryMapper {
    long countByExample(TbBlogCategoryExample example);

    int deleteByExample(TbBlogCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(TbBlogCategory record);

    int insertSelective(TbBlogCategory record);

    List<TbBlogCategory> selectByExample(TbBlogCategoryExample example);

    TbBlogCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") TbBlogCategory record, @Param("example") TbBlogCategoryExample example);

    int updateByExample(@Param("record") TbBlogCategory record, @Param("example") TbBlogCategoryExample example);

    int updateByPrimaryKeySelective(TbBlogCategory record);

    int updateByPrimaryKey(TbBlogCategory record);
}