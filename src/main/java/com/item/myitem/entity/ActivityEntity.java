package com.item.myitem.entity;

import lombok.Data;

@Data
public class ActivityEntity {
    private Integer area_id;
    private String area_name;
    private String date;
    private String time;
    private Integer num;
    private Double fee;
    private Integer type;
    private String activity_name;
    private String content;
    private Integer user_id;
    private String poster;
    private Integer num_now;
}
