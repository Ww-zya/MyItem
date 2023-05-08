package com.item.myitem.controller;

import com.item.myitem.entity.ActivityEntity;
import com.item.myitem.entity.ClubDetailEntity;
import com.item.myitem.entity.UserEntity;
import com.item.myitem.mapper.ActivityMapper;
import com.item.myitem.mapper.ClubMapper;
import com.item.myitem.mapper.UserMapper;
import com.item.myitem.vo.ActivityVOC;
import com.item.myitem.vo.ClubDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    ClubMapper clubMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ActivityMapper activityMapper;

    @RequestMapping("/clubInfo")
    public List<ClubDetailVO> getClubInfo() {
        List<ClubDetailVO> clueDetail = clubMapper.getClubInfo();
        for (ClubDetailVO clubDetailVO : clueDetail) {
            UserEntity userInfo = userMapper.getLoginInfo(clubDetailVO.getOrganizer_id());
            clubDetailVO.setNickname(userInfo.getNickname());
            clubDetailVO.setHead_picture(userInfo.getHead_picture());
        }
        return clueDetail;
    }

    @RequestMapping("/addActivity")
    public void insertActivity(Integer area_id,String area_name,String date,String time,Integer num,Double fee,Integer type,String activity_name,String content,Integer user_id,String poster) {
        System.out.println(area_name);
        System.out.println(poster);
        activityMapper.addActivity(area_id,area_name,date,time,num,fee,type,activity_name,content,user_id,poster);
    }

    @RequestMapping("/getActivityInfo")
    public List<ActivityVOC> activityInfo() {
        return activityMapper.getActivityInfo();
    }
}
