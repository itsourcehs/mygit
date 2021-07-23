package com.evan.wj.service;

import com.evan.wj.pojo.AdminRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AdminRoleService
 * @Description TODO
 * @Date 2021/7/23 18:40
 * @Created by 123456
 */
@Service
public class AdminRoleService {
    @Resource
    private UserService userService;
    public List<AdminRole> listRolesByUser(String username){
        userService.getByName(username)
    }
}
