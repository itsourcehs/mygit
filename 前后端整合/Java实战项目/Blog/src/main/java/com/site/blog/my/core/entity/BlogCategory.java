package com.site.blog.my.core.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: Blog
 * @description: 博客分类实体类
 * @author: Mr.Huang
 * @create: 2021-05-19 17:16
 **/

public class BlogCategory {
    /**分类id*/
    private Integer categoryId;
    /**分类名称*/
    private String categoryName;
    /**分类图标*/
    private String categoryIcon;
    /**分类等级*/
    private Integer categoryRank;
    /**类别是否已删除*/
    private Byte isDeleted;
    /**类别创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        // trim() 方法用于删除字符串的头尾空白符
        this.categoryName = categoryName == null?null:categoryName.trim();
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null?null:categoryIcon.trim();
    }

    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
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
        return "BlogCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryIcon='" + categoryIcon + '\'' +
                ", categoryRank=" + categoryRank +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                '}';
    }
}
