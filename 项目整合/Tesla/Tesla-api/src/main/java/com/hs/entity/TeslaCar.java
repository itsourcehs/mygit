package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeslaCar {
    private Integer carId;

    private String carTitle;

    private String carImgurl;

    private String carEndurance;

    private String carAccelerate;

    private String carMaxspeed;

}
