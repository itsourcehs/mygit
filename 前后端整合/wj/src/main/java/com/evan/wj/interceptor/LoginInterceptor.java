package com.evan.wj.interceptor;

import com.evan.wj.pojo.User;
import org.apache.commons.lang.StringUtils;
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
        HttpSession session = request.getSession();
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
