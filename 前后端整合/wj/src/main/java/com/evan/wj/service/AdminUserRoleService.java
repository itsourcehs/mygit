package com.evan.wj.service;

import com.evan.wj.dao.AdminUserRoleDAO;
import com.evan.wj.pojo.AdminUserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AdminUserRoleService
 * @Description TODO
 * @Date 2021/7/20 12:30
 * @Created by 123456
 */
@Service
public class AdminUserRoleService {
    @Resource
    private AdminUserRoleDAO adminUserRoleDAO;
    public List<AdminUserRole> listAllByUid(int uid){
        return adminUserRoleDAO.findAllByUid(uid);
    }
}
