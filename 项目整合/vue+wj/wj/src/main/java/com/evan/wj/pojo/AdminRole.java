package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @Classname AdminRole
 * @Description TODO
 * @Date 2021/7/19 18:27
 * @Created by 123456
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admin_role")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;

    @Column(name = "name_zh")
    private String nameZh;
    private boolean enabled;

    @Transient
    private List<AdminPermission> perms;

    @Transient
    private List<AdminMenu> menus;
}
