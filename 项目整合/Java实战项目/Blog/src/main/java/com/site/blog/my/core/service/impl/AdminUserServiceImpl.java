package com.site.blog.my.core.service.impl;

/**Mapper接口层 == dao层*/
import com.site.blog.my.core.dao.*;
/**实体类 == entity类*/
import com.site.blog.my.core.entity.*;
import com.site.blog.my.core.service.AdminUserService;
import com.site.blog.my.core.util.MD5Util;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-23 23:37
 **/

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password,"UTF-8");
        return adminUserMapper.login(userName,passwordMd5);
    }

    @Override
    public AdminUser getUserDeteilById(Integer loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        /**判断当前用户非空才能进行修改*/
        if(adminUser != null){
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword,"UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword,"UTF-8");

            /**判断原密码是否正确*/
            if(originalPasswordMd5.equals(adminUser.getLoginPassword())){
                /**设置新密码并修改*/
                adminUser.setLoginPassword(newPasswordMd5);
                /**修改成功则返回true*/
                if(adminUserMapper.updateByPrimaryKey(adminUser) > 0){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        /**当前用户不为空才能修改*/
        if(adminUser != null){
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            /**修改成功返回true*/
            if(adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0){
                return true;
            }
        }
        return false;
    }

}
