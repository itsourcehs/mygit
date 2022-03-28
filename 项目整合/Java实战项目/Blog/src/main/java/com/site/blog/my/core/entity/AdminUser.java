package com.site.blog.my.core.entity;

/**
 * @program: Blog
 * @description: 后台用户实体类
 * @author: Mr.Huang
 * @create: 2021-05-19 18:40
 **/

public class AdminUser {
    /**后台用户id*/
    private Integer adminUserId;
    /**登录用户名*/
    private String loginUserName;
    /**登录用户密码*/
    private String loginPassword;
    /**昵称*/
    private String nickName;
    /**是否被锁定*/
    private Byte locked;

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        // trim() 方法用于删除字符串的头尾空白符
        this.loginUserName = loginUserName == null?null:loginUserName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null?null:loginPassword.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null?null:nickName.trim();
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;

    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "adminUserId=" + adminUserId +
                ", loginUserName='" + loginUserName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", nickName='" + nickName + '\'' +
                ", locked=" + locked +
                '}';
    }
}
