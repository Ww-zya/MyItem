package com.item.myitem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PostsEntity {
    private Integer posts_id;
    private Integer user_id;
    private Integer area_id;
    private Integer is_quality;
    private Date posts_time;
    private String posts_title;
    private String posts_content;
    private String posts_comNum;
    private String posts_goodNum;
}
