package com.evan.wj.controller;

import com.evan.wj.dao.AdminPermissionDAO;
import com.evan.wj.dao.AdminRoleDAO;
import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname RoleController
 * @Description TODO
 * @Date 2021/7/27 14:40
 * @Created by 123456
 */
@Controller
public class RoleController {
    @Autowired
    private AdminRoleDAO adminRoleDAO;
    @Autowired
    private AdminPermissionDAO adminPermissionDAO;

    /*
     * 查询所有角色列表
     */
    @GetMapping("/api/admin/role")
    @ResponseBody
    public List<AdminRole> listRoles(){
        return adminRoleDAO.findAll();
    }

    /*
     * 查询所有功能配置列表
     */
    @GetMapping("/api/admin/role/perm")
    @ResponseBody
    public List<AdminPermission> listPerms(){
        return adminPermissionDAO.findAll();
    }

    /*
     * 查询出所有菜单配置列表
     */
    @GetMapping("/api/admin/role/menu")
    @ResponseBody
    public List<AdminMenu> listMenus(){}
}
