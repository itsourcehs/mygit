package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.*;
import com.site.blog.my.core.entity.BlogCategory;
import com.site.blog.my.core.service.CategoryService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-24 00:16
 **/

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private BlogCategoryMapper blogCategoryMapper;

    @Resource
    private BlogMapper blogMapper;

    @Override
    public PageResult getBlogCategoryPage(PageQueryUtil pageUtil) {
        return null;
    }

    @Override
    public int getTotalCategories() {
        return 0;
    }

    @Override
    public Boolean saveCategory(String categoryName, String categoryIcon) {
        return null;
    }

    @Override
    public Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public List<BlogCategory> getAllCategories() {
        return null;
    }
}
