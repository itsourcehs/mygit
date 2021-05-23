package com.site.blog.my.core.dao;

import mybatis.generator.model.TbBlogComment;
import mybatis.generator.model.TbBlogCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogCommentMapper {
    long countByExample(TbBlogCommentExample example);

    int deleteByExample(TbBlogCommentExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(TbBlogComment record);

    int insertSelective(TbBlogComment record);

    List<TbBlogComment> selectByExample(TbBlogCommentExample example);

    TbBlogComment selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("record") TbBlogComment record, @Param("example") TbBlogCommentExample example);

    int updateByExample(@Param("record") TbBlogComment record, @Param("example") TbBlogCommentExample example);

    int updateByPrimaryKeySelective(TbBlogComment record);

    int updateByPrimaryKey(TbBlogComment record);
}