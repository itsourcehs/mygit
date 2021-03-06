package com.evan.wj.dao;

import com.evan.wj.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdminRoleMenuDAO extends JpaRepository<AdminRoleMenu, Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);

    List<AdminRoleMenu> findAllByRidIn(List<Integer> rids); //此方法报npe

    void deleteAllByRid(int rid);
}
