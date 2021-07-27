package com.evan.wj.service;

import com.evan.wj.dao.AdminUserRoleDAO;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.AdminUserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    /*
     * 修改admin_user_role表中的内容
     */
    @Transactional
    public void saveRoleChanges(int uid, List<AdminRole> roles){
        //1.删除原有用户对应的行
        adminUserRoleDAO.deleteAllByUid(uid);
        //2.再根据新传递的数据做插入操作
        List<AdminUserRole> urs = new ArrayList<>();
        roles.forEach(r -> {
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(r.getId());
            urs.add(ur);
        });
        adminUserRoleDAO.saveAll(urs);
    }
}
