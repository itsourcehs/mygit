package com.evan.wj.filter;

import com.evan.wj.service.AdminPermissionService;
import com.evan.wj.utils.SpringContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;


import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @Classname URLPathMatchingFilter
 * @Description TODO
 * @Date 2021/7/26 15:52
 * @Created by 123456
 */
//自定义路径过滤器
public class URLPathMatchingFilter extends PathMatchingFilter {
    @Resource
    private AdminPermissionService adminPermissionService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //1.放行options请求
        if(HttpMethod.OPTIONS.toString().equals(req.getMethod())){
            res.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        if(null == adminPermissionService){
            adminPermissionService = SpringContextUtils.getContext()
                    .getBean(AdminPermissionService.class);
        }
        String api = getPathWithinApplication(request);
        System.out.println("访问接口:" + api);

        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            System.out.println("需要登录");
            return false;
        }
        //判断访问接口是否需要过滤(数据库是否有对应信息)
        boolean b = adminPermissionService.needFilter(api);
        if(!b){
            System.out.println("接口:" + api + "无需权限");
            return true;
        }else {
            System.out.println("验证访问权限:" + api);
            //判断当前用户是否有相应权限
            boolean hasPermission = false;
            String username = subject.getPrincipal().toString();
            Set<String> permissionAPIs = adminPermissionService.listPermissionURLsByUser(username);
            for(String Api : permissionAPIs){
                if(Api.equals(api)){
                    hasPermission = true;
                    break;
                }
            }
        if(hasPermission){
            System.out.println("访问权限:" + api + "验证成功");
            return true;
        }else {
            System.out.println("当前用户没有访问接口:" + api + "的权限");
            return false;
        }
        }
    }
}
