package com.item.myitem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SquareInfoEntity {
    private Integer userId;
    private String nickname;
    private String head;
    private Integer postsId;
    private String title;
    private String content;
    private Date time;
}
