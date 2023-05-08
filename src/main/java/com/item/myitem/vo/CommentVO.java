package com.item.myitem.vo;

import com.item.myitem.entity.CommentEntity;
import lombok.Data;

import java.util.List;

@Data
public class CommentVO extends CommentEntity {
    private List<ComChildVO> children;
    private String username;
    private String userHead;
    private String userArea;
}
