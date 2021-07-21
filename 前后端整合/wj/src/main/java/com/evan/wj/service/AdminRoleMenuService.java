package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleMenuDAO;
import com.evan.wj.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AdminRoleMenuService
 * @Description TODO
 * @Date 2021/7/20 11:49
 * @Created by 123456
 */
@Service
public class AdminRoleMenuService {
    //@Resource
    AdminRoleMenuDAO adminRoleMenuDAO;

    public List<AdminRoleMenu> findAllByRid(int rid){
        return adminRoleMenuDAO.findAllByRid(rid);
    }
    public List<AdminRoleMenu> findAllByRid(List<Integer> rids){
        return adminRoleMenuDAO.findAllByRid(rids);
    }
}
