package com.item.myitem.controller;

import com.item.myitem.dto.RegisterDTO;
import com.item.myitem.entity.UserEntity;
import com.item.myitem.mapper.PostsMapper;
import com.item.myitem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PostsMapper postsMapper;

    //登录时比对数据库所有用户
    @RequestMapping("/login")
    public UserEntity loginInfo(String tel, String password) {
//        System.out.println(tel);
        return userMapper.getUserById(tel, password);
    }

    //成功登录后用户信息的获取
    @RequestMapping("/userInfo")
    public UserEntity userInfo(Integer id) {
        return userMapper.getLoginInfo(id);
    }

    @RequestMapping("/register")
    public void register(@RequestBody RegisterDTO reg) {
        System.out.println(reg.getTel());
    }

    @RequestMapping("/publish")
    public void insert(Integer id, String title, String content) {
        postsMapper.insertPosts(id,title,content);
    }

    @RequestMapping("/allUser")
    public List<UserEntity> getAllUser() {
        return userMapper.getUserInfo();
    }

    @RequestMapping("/addFriend")
    public void addFriend(Integer from_id,Integer to_id) {
        userMapper.addFriend(from_id,to_id);
    }

    //查找是否有相同好友
    @RequestMapping("/sameFriend")
    public boolean findSame(Integer from_id, Integer to_id) {
//        System.out.println(from_id);
//        System.out.println(to_id);
        if(userMapper.sameFriend(from_id, to_id)!=null) {
            return true;
        }
        return false;
    }

    //查找好友数量
    @RequestMapping("/friendCnt")
    public Integer countFriend(Integer from_id) {
        System.out.println(from_id);
        return userMapper.friendCnt(from_id);
    }

    @RequestMapping("/selectByName")
    public List<UserEntity> selectByName(String name) {
        System.out.println("name1111111");
        System.out.println(name);
        return userMapper.selectByName(name);
    }
}
