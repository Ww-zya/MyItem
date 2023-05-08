package com.item.myitem.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityVOC extends ActivityVO{
    private Integer id;
    private String nickname;
    private String tel;
    private String password;
    private String email;
    private String sex;
    private Date create_time;
    private String head_picture;
    private String per_sign;
    private String area;
}
