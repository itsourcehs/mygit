package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname AdminRolePermission
 * @Description TODO
 * @Date 2021/7/26 15:13
 * @Created by 123456
 */
@Data
@ToString
@Entity
@Table(name = "admin_role_permission")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int rid;
    private int pid;
}
