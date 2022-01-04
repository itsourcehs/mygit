package com.site.blog.my.core.dao;

import com.site.blog.my.core.entity.BlogComment;
import mybatis.generator.model.BlogCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.*;


public interface BlogCommentMapper {
    long countByExample(BlogCommentExample example);

    int deleteByExample(BlogCommentExample example);

    int deleteByPrimaryKey(Long commentId);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    List<BlogComment> selectByExample(BlogCommentExample example);

    BlogComment selectByPrimaryKey(Long commentId);

    int updateByExampleSelective(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByExample(@Param("record") BlogComment record, @Param("example") BlogCommentExample example);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);

    int getTotalBlogComments(Map map);

    List<BlogComment> findBlogCommentList(Map map);

    /**批量审核 --
     * 返回1表示批量审核成功
     * 返回0表示审核状态待审核
     * */
    int checkDone(Integer[] ids);

    /**批量删除 --
     * 返回1表示批量删除成功
     * 默认0
     * */
    int deleteBatch(Integer[] ids);


}