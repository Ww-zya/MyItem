package com.item.myitem.entity;

import lombok.Data;

@Data
public class ScriptDetailEntity {
    private Integer id;
    private String script_name;
    private Double script_time;
    private Integer people_number;
    private String script_introduce;
    private String script_img;
    private Integer script_man;
    private Integer script_woman;
    private Integer publish_date;
    private Integer is_limit;
    private Integer script_hot;
    private Double script_score;
}
