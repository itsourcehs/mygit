package com.evan.wj.service;

import com.evan.wj.dao.UserDAO;
import com.evan.wj.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/6/29 18:14
 * @Created by 123456
 */
@Service
public class UserService {
    @Resource
    UserDAO userDAO;

    public User getByName(String username){
        return userDAO.findByUsername(username);
    }

    public boolean isExist(String username){
        return null!= getByName(username);
    }

    public User get(String username,String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user){
        userDAO.save(user);
    }

    public List<User> list(){
        return userDAO.findAll();
    }


}
