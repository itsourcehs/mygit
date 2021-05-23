package com.site.blog.my.core.dao;

import java.util.List;

import com.site.blog.my.core.util.PageQueryUtil;
import mybatis.generator.model.TbBlog;
import mybatis.generator.model.TbBlogExample;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    long countByExample(TbBlogExample example);

    int deleteByExample(TbBlogExample example);

    int deleteByPrimaryKey(Long blogId);

    int insert(TbBlog record);

    int insertSelective(TbBlog record);

    List<TbBlog> selectByExampleWithBLOBs(TbBlogExample example);

    List<TbBlog> selectByExample(TbBlogExample example);

    TbBlog selectByPrimaryKey(Long blogId);

    int updateByExampleSelective(@Param("record") TbBlog record, @Param("example") TbBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") TbBlog record, @Param("example") TbBlogExample example);

    int updateByExample(@Param("record") TbBlog record, @Param("example") TbBlogExample example);

    int updateByPrimaryKeySelective(TbBlog record);

    int updateByPrimaryKeyWithBLOBs(TbBlog record);

    int updateByPrimaryKey(TbBlog record);

    int getTotalBlogs(PageQueryUtil pageUtil);

    TbBlog selectBySubUrl(String subUrl);
}