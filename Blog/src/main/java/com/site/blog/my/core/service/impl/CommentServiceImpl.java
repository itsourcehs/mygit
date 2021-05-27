package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.BlogCommentMapper;
import com.site.blog.my.core.entity.BlogComment;
import com.site.blog.my.core.service.CommentService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Override
    public Boolean checkDone(Integer[] ids) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public Boolean reply(Long commentId, String replyBody) {
        return null;
    }

    @Override
    public PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page) {
        return null;
    }
}
