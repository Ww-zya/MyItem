package com.item.myitem.controller;

import com.item.myitem.entity.PostsEntity;
import com.item.myitem.entity.SquareInfoEntity;
import com.item.myitem.mapper.PostsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/square")
public class SquareController {
    @Autowired
    PostsMapper postsMapper;

    @RequestMapping("/info")
    public List<SquareInfoEntity> information() {
        return postsMapper.getSquareInfo();
    }

    @RequestMapping("/onePost")
    public PostsEntity onePostsInfo(Integer postsId) {
//        System.out.println(postsId);
        return postsMapper.getPostsInfo(postsId);
    }
}
