package com.evan.wj.service;

import com.evan.wj.dao.JotterArticleDAO;
import com.evan.wj.pojo.JotterArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @program: wj
 * @description:
 * @author: Mr.Huang
 * @create: 2021-08-01 22:49
 **/
@Service
public class JotterArticleService {
    @Autowired
    private JotterArticleDAO jotterArticleDAO;

    public Page list(int page,int size){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return jotterArticleDAO.findAll(PageRequest.of(page,size,sort));
    }

    public void addOrUpdate(JotterArticle article){
        jotterArticleDAO.save(article);
    }

    public JotterArticle findById(int id){
        return jotterArticleDAO.findById(id);
    }

    public void delete(int id){
        jotterArticleDAO.deleteById(id);
    }
}
