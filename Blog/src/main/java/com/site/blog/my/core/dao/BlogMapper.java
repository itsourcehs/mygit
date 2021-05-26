package com.site.blog.my.core.dao;

import java.util.List;

import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.entity.Blog;
import mybatis.generator.model.TbBlogExample;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    long countByExample(TbBlogExample example);

    int deleteByExample(TbBlogExample example);

    int deleteByPrimaryKey(Long blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(TbBlogExample example);

    List<Blog> selectByExample(TbBlogExample example);

    Blog selectByPrimaryKey(Long blogId);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") TbBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") TbBlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") TbBlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    int getTotalBlogs(PageQueryUtil pageUtil);

    Blog selectBySubUrl(String subUrl);

    List<Blog> findBlogList(PageQueryUtil pageUtil);

    List<Blog> findBlogListByType(@Param("type") int type, @Param("limit") int limit);
}