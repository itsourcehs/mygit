package com.evan.wj.service;

import com.evan.wj.dao.BookDAO;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname BookService
 * @Description TODO
 * @Date 2021/7/1 10:57
 * @Created by 123456
 */

@Service
public class BookService  {
    @Resource
    BookDAO dao;
    @Resource
    CategoryService service;

    public List<Book> list(){
        return dao.findAll(new Sort(Sort.Direction.DESC,"id"));
    }
    /**
     * @Description 当主键存在时更新数据,主键不存在时插入数据
     * @Param
     * @return
     * @date 2021/7/1 11:01
     * @auther 123456
     */
    public void addOrUpdate(Book book){
        dao.save(book);
    }
    public void deleteById(int id){
        dao.deleteById(id);
    }
    public List<Book> listByCategory(int cid){
        return dao.findAllByCategory(service.get(cid));
    }
    public List<Book> Search(String keywords) {
        return dao.findAllByTitleLikeOrAuthorLike('%' + keywords + '%', '%' + keywords + '%');
    }

}
