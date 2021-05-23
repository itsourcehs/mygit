package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.BlogConfigMapper;
import com.site.blog.my.core.service.ConfigService;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-23 20:30
 **/

@Service
public class ConfigServiceImpl implements ConfigService {
    @Resource
    private BlogConfigMapper configMapper;

    @Override
    public int updateConfig(String configName, String configValue) {
        return 0;
    }

    @Override
    public Map<String, String> getAllConfigs() {
        return null;
    }
}
