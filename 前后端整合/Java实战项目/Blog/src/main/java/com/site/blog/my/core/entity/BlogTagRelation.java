package com.site.blog.my.core.entity;

import java.util.Date;

/**
 * @program: Blog
 * @description: 博客与标签关系实体类
 * @author: Mr.Huang
 * @create: 2021-05-19 21:14
 **/

public class BlogTagRelation {
    /**关联id*/
    private Long blogId;
    /**标签id*/
    private Integer tagId;
    /**创建时间*/
    private Date createTime;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BlogTagRelation{" +
                "blogId=" + blogId +
                ", tagId=" + tagId +
                ", createTime=" + createTime +
                '}';
    }
}
