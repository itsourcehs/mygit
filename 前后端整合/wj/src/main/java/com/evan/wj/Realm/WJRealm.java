package com.evan.wj.Realm;

import com.evan.wj.pojo.User;
import com.evan.wj.service.AdminPermissionService;
import com.evan.wj.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Classname WJRealm
 * @Description TODO
 * @Date 2021/7/6 10:43
 * @Created by 123456
 */
public class WJRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    @Resource
    private AdminPermissionService adminPermissionService;

    //获取授权信息方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //return new SimpleAuthorizationInfo();
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> permissions = adminPermissionService.listPermissionURLsByUser(username);

        //将权限放入授权信息中
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        s.setStringPermissions(permissions);
        return s;
    }

    //获取认证信息方法,即根据token中的用户名从数据库获取密码和盐等并返回
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String userName = token.getPrincipal().toString();
        User user = userService.getByName(userName);
        if(user != null){
            String passwordInDB = user.getPassword();
            String salt = user.getSalt();
            return new SimpleAuthenticationInfo(userName
                    ,passwordInDB
                    , ByteSource.Util.bytes(salt)
                    ,getName());
        }else {
            return null;
        }
    }
}
