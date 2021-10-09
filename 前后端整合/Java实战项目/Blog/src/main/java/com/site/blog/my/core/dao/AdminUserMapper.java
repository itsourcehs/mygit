package com.site.blog.my.core.dao;

/**实体类 == entity类*/
import com.site.blog.my.core.entity.*;
import mybatis.generator.model.AdminUserExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface AdminUserMapper {
    long countByExample(AdminUserExample example);

    int deleteByExample(AdminUserExample example);

    int deleteByPrimaryKey(Integer adminUserId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    List<AdminUser> selectByExample(AdminUserExample example);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);

    /**
     * @Description: 登陆方法
     * @Param: username password
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);
}