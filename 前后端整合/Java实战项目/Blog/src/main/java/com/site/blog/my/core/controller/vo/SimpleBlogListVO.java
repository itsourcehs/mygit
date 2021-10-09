package com.site.blog.my.core.controller.vo;

import sun.dc.pr.PRError;

import java.io.Serializable;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-20 11:16
 **/

public class SimpleBlogListVO implements Serializable {
    /**博客id*/
    private Long blogId;
    /**博客标题*/
    private String blogTitle;

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
}
