package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/6/29 15:51
 * @Created by 123456
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String username;
    private String password;
    private String salt;

    private String name;
    private String phone;

    @Email(message = "请输入正确的邮箱")
    private String email;

    private boolean enabled;

    @Transient
    private List<AdminRole> roles;
}
