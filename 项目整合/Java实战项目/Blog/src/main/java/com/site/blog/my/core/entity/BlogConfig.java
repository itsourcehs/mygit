package com.site.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @program: Blog
 * @description: 博客配置实体类
 * @author: Mr.Huang
 * @create: 2021-05-19 18:45
 **/

public class BlogConfig {
    /**配置名称*/
    private String configName;
    /**配置值*/
    private String configValue;
    /**创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**更新时间*/
    private Date updateTime;

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        // trim() 方法用于删除字符串的头尾空白符
        this.configName = configName == null?null:configName.trim();

    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null?null:configValue.trim();
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

    @Override
    public String toString() {
        return "BlogConfig{" +
                "configName='" + configName + '\'' +
                ", configValue='" + configValue + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
