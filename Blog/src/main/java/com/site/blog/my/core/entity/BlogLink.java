package com.site.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: Blog
 * @description: 博客链接
 * @author: Mr.Huang
 * @create: 2021-05-19 20:58
 **/

public class BlogLink {
    /**链接id*/
    private Integer linkId;
    /**链接类型*/
    private Byte linkType;
    /**链接名称*/
    private String linkName;
    /**链接地址*/
    private String linkUrl;
    /**链接描述*/
    private String linkDescription;
    /**链接等级*/
    private Integer linkRank;
    /**链接是否已删除*/
    private Byte isDeleted;

    /**链接创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Byte getLinkType() {
        return linkType;
    }

    public void setLinkType(Byte linkType) {
        this.linkType = linkType;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null?null:linkName.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null?null:linkUrl.trim();
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription == null?null:linkDescription.trim();
    }

    public Integer getLinkRank() {
        return linkRank;
    }

    public void setLinkRank(Integer linkRank) {
        this.linkRank = linkRank;
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

    @Override
    public String toString() {
        return "BlogLink{" +
                "linkId=" + linkId +
                ", linkType=" + linkType +
                ", linkName='" + linkName + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", linkDescription='" + linkDescription + '\'' +
                ", linkRank=" + linkRank +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                '}';
    }
}
