package com.site.blog.my.core.service;

import com.site.blog.my.core.entity.BlogCategory;
import com.site.blog.my.core.util.PageQueryUtil;
import com.site.blog.my.core.util.PageResult;

import java.util.List;

public interface CategoryService {

    /**
     * @Description: 查询分类的分页数据
     * @Param: pageUtil
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/24
     */
    PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

    int getTotalCategories();

    /**
     * @Description: 添加分类数据
     * @Param: categoryName,categoryIcon
     * @return: 
     * @Author: Mr.Huang
     * @Date: 2021/5/24
     */
    Boolean saveCategory(String categoryName,String categoryIcon);

    Boolean updateCategory(Integer categoryId,String categoryName,String categoryIcon);

    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();
}
