package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname AdminRoleMenu
 * @Description TODO
 * @Date 2021/7/19 18:27
 * @Created by 123456
 */
@Data
@ToString
@Entity
@Table(name = "admin_role_menu")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class AdminRoleMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int rid;
    private int mid;
}
