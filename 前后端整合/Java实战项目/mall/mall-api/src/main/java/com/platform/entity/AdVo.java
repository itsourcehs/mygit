package com.platform.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname AdVo
 * @Description  “广告”
 * @Date 2021/10/13 14:42
 * @Created by 123456
 */
@Data
@ToString
public class AdVo implements Serializable {
    // 自定义序列号
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //广告位置Id
    private Integer ad_position_id;
    //形式
    private Integer media_type;
    //广告名称
    private String name;
    //链接
    private String link;
    //图片
    private String image_url;
    //内容
    private String content;
    //结束时间
    private Date end_time;
    //状态
    private Integer enabled;
}
