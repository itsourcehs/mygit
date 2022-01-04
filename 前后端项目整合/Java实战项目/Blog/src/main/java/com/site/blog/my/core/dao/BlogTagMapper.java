package com.site.blog.my.core.dao;

import com.site.blog.my.core.entity.BlogTag;
import com.site.blog.my.core.util.PageQueryUtil;
import mybatis.generator.model.TbBlogTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogTagMapper {
    long countByExample(TbBlogTagExample example);

    int deleteByExample(TbBlogTagExample example);

    int deleteByPrimaryKey(Integer tagId);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    List<BlogTag> selectByExample(TbBlogTagExample example);

    BlogTag selectByPrimaryKey(Integer tagId);

    BlogTag selectByTagName(String tagName);

    int updateByExampleSelective(@Param("record") BlogTag record, @Param("example") TbBlogTagExample example);

    int updateByExample(@Param("record") BlogTag record, @Param("example") TbBlogTagExample example);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    int batchInsertBlogTag(List<BlogTag> tagList);

    List<BlogTag> findTagList(PageQueryUtil pageUtil);

    int getTotalTags(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);
}