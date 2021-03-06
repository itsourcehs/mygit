package com.evan.wj.config;

import com.evan.wj.Realm.WJRealm;
import com.evan.wj.filter.URLPathMatchingFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Classname ShiroConfiguration
 * @Description TODO
 * @Date 2021/7/6 11:19
 * @Created by 123456
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /*

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        return bean;
    }
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getWJRealm());
        return securityManager;
    }

    @Bean
    public WJRealm getWJRealm() {
        WJRealm wjRealm = new WJRealm();
        wjRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return wjRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieObject = new CookieRememberMeManager();
        cookieObject.setCookie(rememberMeCookie());
        cookieObject.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
        return cookieObject;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(259200000);
        return cookie;
    }

    public URLPathMatchingFilter getURLPathMatchingFilter() {
        return new URLPathMatchingFilter();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager sm) {
        ShiroFilterFactoryBean sffb = new ShiroFilterFactoryBean();
        sffb.setSecurityManager(sm);
        Map<String, String> fcdm = new LinkedHashMap<String, String>();
        //1.????????????????????????
        Map<String, Filter> customizedFilter = new HashMap<>();
        //2.????????????????????????,,??????,????????????????????????
        customizedFilter.put("url", getURLPathMatchingFilter());
        //???????????????
        fcdm.put("/api/authentication", "authc");
        fcdm.put("/api/menu", "authc");
        fcdm.put("/api/admin/**", "authc");
        //3.????????????????????????-??????????????????
        fcdm.put("/api/admin/**", "url");
        //4.????????????????????????
        sffb.setFilters(customizedFilter);
        sffb.setFilterChainDefinitionMap(fcdm);
        return sffb;
    }
}
