package com.site.blog.my.core.service;

import java.util.Map;

public interface ConfigService {
    
    /**
     * @Description: 修改配置项
     * @Param: configName configValue
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    int updateConfig(String configName,String configValue);
    
    /**
     * @Description: 获取所有的配置项
     * @Param:
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    Map<String,String> getAllConfigs();
}
