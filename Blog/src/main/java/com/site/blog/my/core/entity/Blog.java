package com.site.blog.my.core.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @program: Blog
 * @description: blog实体类
 * @author: Mr.Huang
 * @create: 2021-05-19 16:12
 **/

public class Blog {
    /**博客id*/
    private Long blogid;
    /**博客标题*/
    private String blogTitle;
    /**博客子URL*/
    private String blogSubUrl;
    /**博客封面图片*/
    private String blogCoverImage;
    /**博客分类id*/
    private Integer blogCategoryId;
    /**博客分类名称*/
    private String blogCategoryName;
    /**博客标签*/
    private String blogTags;
    /**博客状态*/
    private Byte blogStatus;
    /**博客浏览量*/
    private Long blogViews;
    /**是否启用备注*/
    private Byte enableComment;
    /**博客是否已删除*/
    private Byte isDeleted;

    /**博客创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**博客更新时间*/
    private Date updateTime;
    /**博客内容*/
    private String blogContent;

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        // trim() 方法用于删除字符串的头尾空白符
        this.blogTitle = blogTitle == null?null:blogTitle.trim();
    }

    public String getBlogSubUrl() {
        return blogSubUrl;
    }

    public void setBlogSubUrl(String blogSubUrl) {
        this.blogSubUrl = blogSubUrl == null?null:blogSubUrl.trim();
    }

    public String getBlogCoverImage() {
        return blogCoverImage;
    }

    public void setBlogCoverImage(String blogCoverImage) {
        this.blogCoverImage = blogCoverImage == null?null:blogCoverImage.trim();
    }

    public Integer getBlogCategoryId() {
        return blogCategoryId;
    }

    public void setBlogCategoryId(Integer blogCategoryId) {
        this.blogCategoryId = blogCategoryId;
    }

    public String getBlogCategoryName() {
        return blogCategoryName;
    }

    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName == null?null:blogCategoryName.trim();
    }

    public String getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags == null?null:blogTags.trim();
    }

    public Byte getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Byte blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Long getBlogViews() {
        return blogViews;
    }

    public void setBlogViews(Long blogViews) {
        this.blogViews = blogViews;
    }

    public Byte getEnableComment() {
        return enableComment;
    }

    public void setEnableComment(Byte enableComment) {
        this.enableComment = enableComment;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null?null:blogContent.trim();
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogid=" + blogid +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogSubUrl='" + blogSubUrl + '\'' +
                ", blogCoverImage='" + blogCoverImage + '\'' +
                ", blogCategoryId=" + blogCategoryId +
                ", blogCategoryName='" + blogCategoryName + '\'' +
                ", blogTags='" + blogTags + '\'' +
                ", blogStatus=" + blogStatus +
                ", blogViews=" + blogViews +
                ", enableComment=" + enableComment +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", blogContent='" + blogContent + '\'' +
                '}';
    }
}
