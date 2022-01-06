package com.tesla.entity;

import java.util.List;
import java.util.Map;

public class TeslaCar {
    private Integer carId;

    private String carTitle;

    private String carImgurl;

    private List<Map<String,String>> carConfig;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarTitle() {
        return carTitle;
    }

    public void setCarTitle(String carTitle) {
        this.carTitle = carTitle == null ? null : carTitle.trim();
    }

    public String getCarImgurl() {
        return carImgurl;
    }

    public void setCarImgurl(String carImgurl) {
        this.carImgurl = carImgurl == null ? null : carImgurl.trim();
    }

    public List<Map<String,String>> getCarConfig() {
        return carConfig;
    }

    public void setCarConfig(List<Map<String,String>> carConfig) {
        this.carConfig = carConfig;
    }
}
