package com.evan.wj.service;

import com.evan.wj.dao.UserDAO;
import com.evan.wj.pojo.AdminRole;
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
    @Resource
    AdminRoleService adminRoleService;
    @Resource
    AdminUserRoleService adminUserRoleService;

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

    /*
     * 此方法将所有用户信息和对应的角色信息一起查询出来
     */
    public List<User> list(){
        List<User> users = userDAO.findAll();
        List<AdminRole> roles;
        for(User user : users){
            roles = adminRoleService.listRolesByUser(user.getUsername());
            user.setRoles(roles);
        }
        return users;
    }

    /*
     * 修改用户信息Service
     */
    public void editUser(User user){
        User user1 = userDAO.findByUsername(user.getUsername());
        user1.setName(user.getName());
        user1.setPhone(user.getPhone());
        user1.setEmail(user.getEmail());
        userDAO.save(user1);
        adminUserRoleService.saveRoleChanges(user1.getId(), user.getRoles());
    }

    public void updateUserStatus(User user){
        User user1 = userDAO.findByUsername(user.getUsername());
        user1.setEnabled(user.isEnabled());
        userDAO.save(user1);
    }
}
