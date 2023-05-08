package com.item.myitem.entity;

import lombok.Data;

@Data
public class MessageEntity {
    private Integer id;
    private Integer from_id;
    private Integer to_id;
    private String content;
    private String time;
    private Integer isRead;
}
