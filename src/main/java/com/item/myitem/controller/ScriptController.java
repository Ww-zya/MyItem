package com.item.myitem.controller;

import com.item.myitem.entity.ScriptDetailEntity;
import com.item.myitem.mapper.ScriptMapper;
import com.item.myitem.vo.ScriptDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/script")
public class ScriptController {
    @Autowired
    ScriptMapper scriptMapper;

    @RequestMapping("/details")
    public List<ScriptDetailVO> getScriptDetail(String name) {
        System.out.println(name);
        List<ScriptDetailVO> parent = scriptMapper.getScriptDetail(name);
        for (ScriptDetailVO scriptDetailVO : parent) {
            List<String> types = scriptMapper.getScriptType(scriptDetailVO.getId());
            System.out.println(types);
            scriptDetailVO.setTypename(types);
        }
        return parent;
    }

    @RequestMapping("/hotOrder")
    public List<ScriptDetailEntity> getHotOrder() {
        return scriptMapper.byHotOrder();
    }

    @RequestMapping("/typeOrder")
    public List<ScriptDetailEntity> getTypeOrder(String type) {
        Map<Integer,Integer> map=new HashMap<>();
        List<ScriptDetailEntity> list=scriptMapper.byTypeSearch(type);
        List<ScriptDetailEntity>result=new ArrayList<>();
        for (ScriptDetailEntity scriptDetailEntity : list) {
            if(!map.containsKey(scriptDetailEntity.getId())){
               result.add(scriptDetailEntity);
            }
            map.putIfAbsent(scriptDetailEntity.getId(),1);
        }
        return result;
    }
}
