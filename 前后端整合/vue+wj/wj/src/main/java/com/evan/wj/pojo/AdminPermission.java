package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Classname AdminPermission
 * @Description TODO
 * @Date 2021/7/23 10:45
 * @Created by 123456
 */

@Data
@ToString
@Entity
@Table(name = "admin_permission")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class AdminPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    private String name;
    private String desc_;
    private String url;
}
