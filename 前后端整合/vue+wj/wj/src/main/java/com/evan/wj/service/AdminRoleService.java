package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleDAO;
import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname AdminRoleService
 * @Description TODO
 * @Date 2021/7/23 18:40
 * @Created by 123456
 */
@Service
public class AdminRoleService {
    @Autowired
    private AdminRoleDAO adminRoleDAO;
    @Resource
    private UserService userService;
    @Resource
    private AdminUserRoleService adminUserRoleService;
    @Resource
    private AdminPermissionService adminPermissionService;
    @Resource
    private AdminMenuService adminMenuService;

    public List<AdminRole> listRolesByUser(String username) {
        int uid = userService.getByName(username).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream()
                .map(AdminUserRole::getRid)
                .collect(Collectors.toList());

        return adminRoleDAO.findAllById(rids);
    }

    public void addOrUpdate(AdminRole adminRole) {
        adminRoleDAO.save(adminRole);
    }


    public List<AdminRole> listWithPermsAndMenus() {
        List<AdminRole> roles = adminRoleDAO.findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }
}
