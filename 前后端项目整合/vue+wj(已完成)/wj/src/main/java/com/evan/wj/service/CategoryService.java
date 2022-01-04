package com.evan.wj.service;

import com.evan.wj.dao.CategoryDAO;
import com.evan.wj.pojo.Category;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname CategoryService
 * @Description TODO
 * @Date 2021/7/1 10:53
 * @Created by 123456
 */

@Service
public class CategoryService {
    @Resource
    CategoryDAO dao;

    public List<Category> list() {
        return dao.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    public Category get(int id) {
        return dao.findById(id).orElse(null);
    }
}
