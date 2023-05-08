package com.item.myitem.vo;

import com.item.myitem.entity.ClubDetailEntity;
import lombok.Data;

@Data
public class ClubDetailVO extends ClubDetailEntity {
    private String nickname;
    private String head_picture;
}
