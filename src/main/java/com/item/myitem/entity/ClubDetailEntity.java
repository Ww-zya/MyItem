package com.item.myitem.entity;

import lombok.Data;

@Data
public class ClubDetailEntity {
    private Integer id;
    private String name;
    private String introduce;
    private Integer organizer_id;
    private String notice;
    private String activity_day;
    private String club_area;
    private Integer members_num;
    private Double price;
    private String poster;
}
