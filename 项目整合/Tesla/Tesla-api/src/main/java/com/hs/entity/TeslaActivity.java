package com.hs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeslaActivity {
    private String id;

    private String activityCover;

    private String activityTitle;

    private String activitySubtitle;

    private String startTime;

    private String endTime;

    private String activityStatus;

    private String activityAddress;

}