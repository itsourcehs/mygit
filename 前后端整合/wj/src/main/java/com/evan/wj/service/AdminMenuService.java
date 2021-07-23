package com.evan.wj.service;

import com.evan.wj.dao.AdminMenuDAO;
import com.evan.wj.pojo.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname AdminMenuService
 * @Description TODO
 * @Date 2021/7/20 10:11
 * @Created by 123456
 */
@Service
public class AdminMenuService {
    @Autowired
    private AdminMenuDAO adminMenuDAO;
    @Resource
    private UserService userService;
    @Resource
    private AdminUserRoleService adminUserRoleService;
    @Resource
    private AdminRoleMenuService adminRoleMenuService;


    public List<AdminMenu> getAllByParentId(int parentId){
        return adminMenuDAO.findAllByParentId(parentId);
    }

    public List<AdminMenu> getMenusByCurrentUser(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByName(username);
        // 通过userId获取到user_role表中的rid
        List<Integer> rids = adminUserRoleService.listAllByUid(user.getId())
                .stream()
                .map(AdminUserRole ::getRid)
                .collect(Collectors.toList());
        // 通过rid获取到role_menu表中对应的mid列表
        List<Integer> menuIds = adminRoleMenuService.findAllByRidIn(rids)
                .stream()
                .map(AdminRoleMenu ::getMid)
                .collect(Collectors.toList());
        // 通过mid列表获取到menu表中对应的id列表
        List<AdminMenu> menus = adminMenuDAO.findAllById(menuIds)
                .stream()
                .distinct()
                .collect(Collectors.toList());
        //缺个方法
        handleMenus(menus);
        return menus;
    }

    private void handleMenus(List<AdminMenu> menus) {
        menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });
        menus.removeIf(m -> m.getParentId() != 0);
    }
}
