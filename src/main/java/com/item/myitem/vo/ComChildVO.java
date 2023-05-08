package com.item.myitem.vo;

import com.item.myitem.entity.CommentEntity;
import lombok.Data;

@Data
public class ComChildVO extends CommentEntity {
    private String from_username;
    private String to_username;
    private String from_userHead;
}
