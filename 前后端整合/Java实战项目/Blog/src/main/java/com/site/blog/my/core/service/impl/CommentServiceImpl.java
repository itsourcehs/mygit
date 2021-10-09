package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.BlogCommentMapper;
import com.site.blog.my.core.entity.BlogComment;
import com.site.blog.my.core.service.CommentService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-24 00:00
 **/

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private BlogCommentMapper blogCommentMapper;

    @Override
    public Boolean addComment(BlogComment blogComment) {
        return null;
    }

    @Override
    public PageResult getCommentsPage(PageQueryUtil pageUtil) {
        List<BlogComment> comments = blogCommentMapper.findBlogCommentList(pageUtil);
        int total = blogCommentMapper.getTotalBlogComments(pageUtil);
        PageResult pageResult = new PageResult(comments
                ,total
                , pageUtil.getLimit()
                , pageUtil.getPage());
        return pageResult;
    }

    @Override
    public int getTotalComments() {
        return 0;
    }

    /**
     * @Description 批量审核
     * @Param
     * @return
     * @date 2021/5/27 14:51
     * @auther 123456
     */
    @Override
    public Boolean checkDone(Integer[] ids) {
        return blogCommentMapper.checkDone(ids) >0;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return blogCommentMapper.deleteBatch(ids) >0;
    }

    @Override
    public Boolean reply(Long commentId, String replyBody) {
        /**通过评论id拿到评论信息*/
        BlogComment blogComment = blogCommentMapper.selectByPrimaryKey(commentId);
        /**判断审核通过且评论信息不为空时才能回复*/
        if(blogComment != null && blogComment
                .getCommentStatus()
                .intValue() == 1){
            /**回复内容*/
            blogComment.setReplyBody(replyBody);
            /**回复创建时间*/
            blogComment.setReplyCreateTime(new Date());
            /**更新数据库*/
            return blogCommentMapper
                    .updateByPrimaryKeySelective(blogComment) >0;
        }
        return false;
    }

    @Override
    public PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page) {
        return null;
    }
}
