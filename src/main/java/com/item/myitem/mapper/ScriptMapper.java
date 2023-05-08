package com.item.myitem.mapper;

import com.item.myitem.entity.ScriptDetailEntity;
import com.item.myitem.vo.ScriptDetailVO;
import com.item.myitem.vo.ScriptTypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScriptMapper {
    @Select("select * from script_detail where script_name like concat('%',#{name},'%')")
    List<ScriptDetailVO> getScriptDetail(String name);

    @Select("select st.name\n" +
            "from link_scripttype ls inner join script_detail sd on ls.script_id = sd.id\n" +
            "inner join script_tpye st on ls.script_typeid = st.id\n" +
            "where sd.id = #{id}")
    List<String> getScriptType(Integer id);

    @Select("select * from script_detail order by script_hot desc;")
    List<ScriptDetailEntity> byHotOrder();

    List<ScriptDetailEntity> byTypeSearch(@Param("type") String type);
}
