package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.dao.*;
import com.site.blog.my.core.entity.BlogCategory;
import com.site.blog.my.core.service.CategoryService;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<BlogCategory> categoryList = blogCategoryMapper.findCategoryList(pageUtil);
        int total = blogCategoryMapper.getTotalCategories(pageUtil);
        PageResult pageResult = new PageResult(categoryList
                ,total
                , pageUtil.getLimit()
                , pageUtil.getPage());
        return pageResult;
    }

    @Override
    public int getTotalCategories() {
        return 0;
    }

    @Override
    public Boolean saveCategory(String categoryName, String categoryIcon) {
        BlogCategory temp = blogCategoryMapper
                .selectByCategoryName(categoryName);
        if(temp == null){
            BlogCategory blogCategory = new BlogCategory();
            blogCategory.setCategoryName(categoryName);
            blogCategory.setCategoryIcon(categoryIcon);
            return blogCategoryMapper.insertSelective(blogCategory) >0;
        }
        return false;
    }

    @Override
    @Transactional /**在实现类中开启事务*/
    public Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(categoryId);
        if(blogCategory != null){
            blogCategory.setCategoryIcon(categoryIcon);
            blogCategory.setCategoryName(categoryName);
            /**修改分类实体*/
            blogMapper.updateBlogCategorys(categoryName
                    ,blogCategory.getCategoryId()
                    ,new Integer[]{categoryId});
            return blogCategoryMapper.updateByPrimaryKeySelective(blogCategory) >0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public List<BlogCategory> getAllCategories() {
        return blogCategoryMapper.findCategoryList(null);
    }
}
