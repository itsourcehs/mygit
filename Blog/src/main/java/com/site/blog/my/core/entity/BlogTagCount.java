package com.site.blog.my.core.entity;

/**
 * @program: Blog
 * @description: 博客标签统计实体类
 * @author: Mr.Huang
 * @create: 2021-05-19 21:10
 **/

public class BlogTagCount {
    /**标签id*/
    private Integer tagId;
    /**标签名称*/
    private String tagName;
    /**标签统计*/
    private Integer tagCount;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }
}
