package com.item.myitem.vo;

import com.item.myitem.entity.ScriptDetailEntity;
import lombok.Data;

import java.util.List;

@Data
public class ScriptDetailVO extends ScriptDetailEntity {
    private List<String> typename;
}
