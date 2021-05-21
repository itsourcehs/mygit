package com.site.blog.my.core.controller.vo;

import java.util.Date;
import java.util.List;

/**
 * @program: Blog
 * @description: 博客详情-view层与controller层交互
 * @author: Mr.Huang
 * @create: 2021-05-20 10:39
 **/

public class BlogDetailVO {
    /**博客id*/
    private Long blogId;
    /**博客标题*/
    private String blogTitle;
    /**博客分类id*/
    private Integer blogCategoryId;
    /**博客评论统计*/
    private Integer commentCount;
    /**博客分类图标*/
    private String blogCategoryIcon;
    /**博客分类名称*/
    private String blogCategoryName;
    /**博客背景图片*/
    private String blogCoverImage;
    /**博客浏览量*/
    private Long blogViews;
    /**博客标签*/
    private List<String> blogTags;
    /**博客内容*/
    private String blogContent;
    /**博客是否允许评论*/
    private Byte enableComment;
    /**博客创建时间*/
    private Date createTime;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getBlogCategoryIcon() {
        return blogCategoryIcon;
    }

    public void setBlogCategoryIcon(String blogCategoryIcon) {
        this.blogCategoryIcon = blogCategoryIcon;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName;
    }

    public String getBlogCoverImage() {
        return blogCoverImage;
    }

    public void setBlogCoverImage(String blogCoverImage) {
        this.blogCoverImage = blogCoverImage;
    }

    public Long getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
    }

    public List<String> getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(List<String> blogTags) {
        this.blogTags = blogTags;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Byte getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Byte enableComment) {
        this.enableComment = enableComment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
