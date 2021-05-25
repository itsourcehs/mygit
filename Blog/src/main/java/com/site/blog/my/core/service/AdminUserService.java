package com.site.blog.my.core.service;
import com.site.blog.my.core.entity.AdminUser;

public interface AdminUserService {
    AdminUser login(String userName,String password);

    /**
     * @Description: 获取用户信息
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    AdminUser getUserDeteilById(Integer loginUserId);

    /**
     * @Description: 修改当前登录用户的密码
     * @Param: loginUserId,originalPassword,newPassword
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    Boolean updatePassword(Integer loginUserId,String originalPassword,String newPassword);

    /**
     * @Description: 修改当前登录用户的名称信息
     * @Param: loginUserId,loginUserName,nickName
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    Boolean updateName(Integer loginUserId,String loginUserName,String nickName);
}
