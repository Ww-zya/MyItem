package com.item.myitem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CommentEntity {
    private Integer id;
    private Integer posts_id;
    private String content;
    private Integer from_id;
    private Integer to_id;
    private Integer parent_id;
    private Date comment_time;
}
