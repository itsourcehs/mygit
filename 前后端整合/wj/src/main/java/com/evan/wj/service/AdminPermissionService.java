package com.evan.wj.service;

import com.evan.wj.dao.AdminPermissionDAO;
import com.evan.wj.pojo.AdminPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Classname AdminPermissionService
 * @Description TODO
 * @Date 2021/7/23 18:08
 * @Created by 123456
 */
@Service
public class AdminPermissionService {
    @Autowired
    private AdminPermissionDAO adminPermissionDAO;
    public List<AdminPermission> list(){
        return adminPermissionDAO.findAll();
    }

    public Set<String> listPermissionURLsByUser(String username){

    }
}
