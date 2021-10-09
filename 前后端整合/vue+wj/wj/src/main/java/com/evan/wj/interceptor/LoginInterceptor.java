package com.evan.wj.interceptor;

import com.evan.wj.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Classname LoginInterceptor
 * @Description TODO
 * @Date 2021/6/30 11:10
 * @Created by 123456
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requiredAuthPages = new String[]{"index",};
        String uri = request.getRequestURI();
        String page = StringUtils.remove(uri,contextPath+"/");

        if(begingWith(page,requiredAuthPages)){
            User user = (User)session.getAttribute("user");
            if(user == null){
                response.sendRedirect("login");
                return false;
            }
        }
        return true;*/

        /*
         * 放行options请求,否则无法让前端带上自定义的header信息,导致sessionId改变,shiro验证失败
         */
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        //使用shiro验证
        if(!subject.isAuthenticated() && !subject.isRemembered()){
            return false;
        }
        return true;
    }

    private boolean begingWith(String page,String[] requiredAuthPages) {
        boolean result = false;
        for(String requiredAuthPage : requiredAuthPages){
            if(StringUtils.startsWith(page,requiredAuthPage)){
                result = !result;
                break;
            }
        }
        return result;
    }
}
