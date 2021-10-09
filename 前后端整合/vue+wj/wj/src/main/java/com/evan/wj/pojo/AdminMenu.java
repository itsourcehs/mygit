package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @Classname AdminMenu
 * @Description TODO
 * @Date 2021/7/19 18:27
 * @Created by 123456
 */
@Data
@Entity
@Table(name = "admin_menu")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String path;
    private String name;
    private String nameZh;
    private String iconCls;
    private String component;
    private int parentId;
    @Transient
    private List<AdminMenu> children;
}
