package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname AdminUserRole
 * @Description TODO
 * @Date 2021/7/19 18:26
 * @Created by 123456
 */

@Data
@ToString
@Entity
@Table(name = "admin_user_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int uid;
    private int rid;
}
