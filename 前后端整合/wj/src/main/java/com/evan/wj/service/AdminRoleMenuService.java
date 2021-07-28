package com.evan.wj.service;

import com.evan.wj.dao.AdminRoleMenuDAO;
import com.evan.wj.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname AdminRoleMenuService
 * @Description TODO
 * @Date 2021/7/20 11:49
 * @Created by 123456
 */
@Service
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuDAO adminRoleMenuDAO;

    public List<AdminRoleMenu> findAllByRid(int rid){
        return adminRoleMenuDAO.findAllByRid(rid);
    }
    public List<AdminRoleMenu> findAllByRidIn(List<Integer> rids){
        return adminRoleMenuDAO.findAllByRidIn(rids); // npe
    }

    @Modifying
    @Transactional
    public void updateRoleMenu(int rid, Map menuIds){
        //此方法抛出空指针异常
        adminRoleMenuDAO.deleteAllByRid(rid);
        List<AdminRoleMenu> rms = new ArrayList<>();
        for(Integer mid : (List<Integer>)menuIds.get("menusIds")){
            AdminRoleMenu rm = new AdminRoleMenu();
            rm.setMid(mid);
            rm.setRid(rid);
            rms.add(rm);
        }
    }
}
