package com.evan.wj.service;

import com.evan.wj.dao.AdminPermissionDAO;
import com.evan.wj.dao.AdminRolePermissionDAO;
import com.evan.wj.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Autowired
    private AdminRolePermissionDAO adminRolePermissionDAO;
    @Resource
    private AdminRoleService adminRoleService;
    public List<AdminPermission> list(){
        return adminPermissionDAO.findAll();
    }

    public Set<String> listPermissionURLsByUser(String username){
        //通过username获取当前用户的角色列表
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream()
                .map(AdminRole ::getId)
                .collect(Collectors.toList());

        List<Integer> pids = adminRolePermissionDAO.findAllByRidIn(rids)
                .stream()
                .map(AdminRolePermission :: getPid)
                .collect(Collectors.toList());

        List<AdminPermission> perms = adminPermissionDAO.findAllById(pids);
        Set<String> URLs = perms.stream().map(AdminPermission :: getUrl).collect(Collectors.toSet());

        return URLs;
    }
    //判断用户请求接口是否在权限列表中
    public boolean needFilter(String api){
        List<AdminPermission> ps = adminPermissionDAO.findAll();
        for(AdminPermission p : ps){
            if(p.getUrl().equals(api)){
                return true;
            }
        }
        return false;
    }






}
