package com.evan.wj.controller;

import com.evan.wj.dao.AdminPermissionDAO;
import com.evan.wj.dao.AdminRoleDAO;
import com.evan.wj.pojo.AdminMenu;
import com.evan.wj.pojo.AdminPermission;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.AdminMenuService;
import com.evan.wj.service.AdminRoleMenuService;
import com.evan.wj.service.AdminRolePermissionService;
import com.evan.wj.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private AdminMenuService adminMenuService;
    @Resource
    private AdminRoleMenuService adminRoleMenuService;
    @Resource
    private AdminRoleService adminRoleService;
    @Resource
    private AdminRolePermissionService adminRolePermissionService;

    /*
     * 查询所有角色列表
     */
    @GetMapping("/api/admin/role")
    @ResponseBody
    public List<AdminRole> listRoles(){
        //return adminRoleDAO.findAll();
        return adminRoleService.listWithPermsAndMenus();
    }

    @PutMapping("/api/admin/role")
    @ResponseBody
    public Result editRole(@RequestBody AdminRole requestRole){
        adminRoleService.addOrUpdate(requestRole);
        adminRolePermissionService.savePermChanges(requestRole.getId(), requestRole.getPerms());
        String message = "修改角色信息成功";
        return ResultFactory.buildSuccessResult(message);
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
        public List<AdminMenu> listMenus(){
            List<AdminMenu> menus = adminMenuService.getMenusByRoleId(1);
        return menus;
    }

    @PutMapping("/api/admin/role/menu")
    @ResponseBody
    public void updateRoleMenu(@RequestParam int rid, @RequestBody Map<String,List<Integer>> menusIds){
        adminRoleMenuService.updateRoleMenu(rid,menusIds);
    }
}
