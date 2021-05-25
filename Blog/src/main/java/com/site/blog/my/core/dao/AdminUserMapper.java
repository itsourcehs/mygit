package com.site.blog.my.core.dao;

import mybatis.generator.model.AdminUser;
import mybatis.generator.model.AdminUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {
    long countByExample(AdminUserExample example);

    int deleteByExample(AdminUserExample example);

    int deleteByPrimaryKey(Integer adminUserId);

    int insert(com.site.blog.my.core.entity.AdminUser record);

    int insertSelective(com.site.blog.my.core.entity.AdminUser record);

    List<AdminUser> selectByExample(AdminUserExample example);

    com.site.blog.my.core.entity.AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByExample(@Param("record") com.site.blog.my.core.entity.AdminUser record, @Param("example") AdminUserExample example);

    int updateByPrimaryKeySelective(com.site.blog.my.core.entity.AdminUser record);

    int updateByPrimaryKey(com.site.blog.my.core.entity.AdminUser record);

    /**
     * @Description: 登陆方法
     * @Param: username password
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    com.site.blog.my.core.entity.AdminUser login(@Param("userName") String userName, @Param("password") String password);
}