package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.BlogTagCount;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;

import java.util.List;

public interface TagService {

    /**
     * @Description: 查询标签的分页数据
     * @Param: 
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/23
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    int getTotalTags();

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
