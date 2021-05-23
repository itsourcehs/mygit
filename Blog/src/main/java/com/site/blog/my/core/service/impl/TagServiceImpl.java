package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.BlogTagMapper;
import com.site.blog.my.core.dao.BlogTagRelationMapper;
import com.site.blog.my.core.entity.BlogTagCount;
import com.site.blog.my.core.service.TagService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-23 19:46
 **/
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private BlogTagMapper blogTagMapper;
    @Resource
    private BlogTagRelationMapper relationMapper;

    @Override
    public PageResult getBlogTagPage(PageQueryUtil pageUtil) {
        return null;
    }

    @Override
    public int getTotalTags() {
        return 0;
    }

    @Override
    public Boolean saveTag(String tagName) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public List<BlogTagCount> getBlogTagCountForIndex() {
        return null;
    }
}
