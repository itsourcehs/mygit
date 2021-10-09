package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.BlogComment;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;


public interface CommentService {

    /**
     * @Description: 添加评论
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    Boolean addComment(BlogComment blogComment);
    
    /**
     * @Description: 后台管理系统中评论分页功能
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    PageResult getCommentsPage(PageQueryUtil pageUtil);
    
    /**
     * @Description: 统计评论总数量
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    int getTotalComments();

    /**
     * @Description: 批量审核
     * @Param: ids
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    Boolean checkDone(Integer[] ids);

    /**
     * @Description: 批量删除
     * @Param: ids
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    Boolean deleteBatch(Integer[] ids);
    
    /**
     * @Description: 添加回复
     * @Param: commentId,replyBody
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    Boolean reply(Long commentId,String replyBody);
    
    /**
     * @Description: 根据博客文章id和分页参数获取博客文章的怕评论列表
     * @Param: blogId,page
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    PageResult getCommentPageByBlogIdAndPageNum(Long blogId,int page);
}
