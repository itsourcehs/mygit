package com.evan.wj.pojo;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @Classname Category
 * @Description TODO
 * @Date 2021/7/1 10:11
 * @Created by 123456
 */

@Entity
@Table(name = "category")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
