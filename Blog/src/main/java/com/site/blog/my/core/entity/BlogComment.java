package com.site.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.Date;

/**
 * @program: Blog
 * @description: 博客评论实体类
 * @author: Mr.Huang
 * @create: 2021-05-19 18:25
 **/

public class BlogComment {
    /**评论id*/
    private Long commentId;
    /**博客id*/
    private Long blogId;
    /**谁评论的*/
    private String commentator;
    /**邮件*/
    private String email;
    /**网站url*/
    private String websiteUrl;
    /**评论正文*/
    private String commentBody;

    /**评论创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date commentCreateTime;

    /**评论员(由谁评论)ip*/
    private String commentatorIp;
    /**回复正文*/
    private String replyBody;

    /**回复创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date replyCreateTime;

    /**评论状态*/
    private Byte commentStatus;
    /**评论是否已删除*/
    private Byte isDeleted;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getCommentator() {
        return commentator;
    }

    public void setCommentator(String commentator) {
        this.commentator = commentator == null?null:commentator.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null?null:email.trim();
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl == null?null:websiteUrl.trim();
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody == null?null:commentBody.trim();
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public String getCommentatorIp() {
        return commentatorIp;
    }

    public void setCommentatorIp(String commentatorIp) {
        this.commentatorIp = commentatorIp == null?null:commentatorIp.trim();
    }

    public String getReplyBody() {
        return replyBody;
    }

    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody == null?null:replyBody.trim();
    }

    public Date getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(Date replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
                "commentId=" + commentId +
                ", blogId=" + blogId +
                ", commentator='" + commentator + '\'' +
                ", email='" + email + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", commentBody='" + commentBody + '\'' +
                ", commentCreateTime=" + commentCreateTime +
                ", commentatorIp='" + commentatorIp + '\'' +
                ", replyBody='" + replyBody + '\'' +
                ", replyCreateTime=" + replyCreateTime +
                ", commentStatus=" + commentStatus +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
