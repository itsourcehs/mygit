package com.evan.wj.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Classname SpringContextUtils
 * @Description TODO
 * @Date 2021/7/26 16:29
 * @Created by 123456
 */
@Component
public class SpringContextUtils implements ApplicationContextAware{
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContextUtils.context = context;
    }
    public static ApplicationContext getContext(){
        return context;
    }
}
