package com.hs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeslaApply {
    private Integer applyId;

    private String applyFirstname;

    private String applyLastname;

    private String applyEmail;

    private String applyPhone;

    private String applyProvince;

    private String applyCity;

    private String applyStatus;

    private String applyProductid;

    @JsonFormat(locale="zh", timezone="GMT", pattern="yyyy-MM-dd HH:mm:ss")
    private Date applyCreatetime;

    @JsonFormat(locale="zh", timezone="GMT", pattern="yyyy-MM-dd HH:mm:ss")
    private Date applyUpdtetime;
}