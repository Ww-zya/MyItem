package com.item.myitem.mapper;

import com.item.myitem.entity.ActivityEntity;
import com.item.myitem.entity.UserEntity;
import com.item.myitem.vo.ActivityVOC;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivityMapper {
    @Insert("insert into activity(area_id,area_name,date,time,num,fee,type,activity_name,content,user_id,poster) " +
            "values(#{area_id},#{area_name},#{date},#{time},#{num},#{fee},#{type},#{activity_name},#{content},#{user_id},#{poster})")
    void addActivity(Integer area_id,String area_name,String date,String time,Integer num,Double fee,Integer type,String activity_name,String content,Integer user_id,String poster);

    @Select("select * from activity a inner join com_user b on a.user_id = b.id inner join club_detail on a.area_id = b.id order by a.date desc")
    List<ActivityVOC> getActivityInfo();
}
