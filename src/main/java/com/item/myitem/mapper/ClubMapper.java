package com.item.myitem.mapper;

import com.item.myitem.entity.ClubDetailEntity;
import com.item.myitem.vo.ClubDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClubMapper {
    @Select("select * from club_detail")
    List<ClubDetailVO> getClubInfo();
}
