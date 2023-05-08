package com.item.myitem.vo;

import com.item.myitem.entity.ClubDetailEntity;
import com.item.myitem.entity.UserEntity;
import lombok.Data;

@Data
public class ActivityVO extends ClubDetailEntity {
    private Integer id;
    private Integer area_id;
    private String area_name;
    private String date;
    private String time;
    private Integer num;
    private Double fee;
    private String activity_name;
    private String content;
}
