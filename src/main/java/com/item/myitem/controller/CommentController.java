package com.item.myitem.controller;

import com.item.myitem.entity.CommentEntity;
import com.item.myitem.entity.UserEntity;
import com.item.myitem.mapper.CommentMapper;
import com.item.myitem.mapper.UserMapper;
import com.item.myitem.vo.ComChildVO;
import com.item.myitem.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/comment")
    public void insertCom(Integer posts_id,String content,Integer from_id,Integer to_id,Integer parent_id) {
//        System.out.println(content);
        commentMapper.insertPost(posts_id,content,from_id,to_id,parent_id);
    }

    @RequestMapping("/getComment")
    public List<CommentVO> getComment(Integer posts_id) {
//        System.out.println(posts_id);
        List<CommentVO> parent = commentMapper.getPostComment(posts_id);
        for (CommentVO commentVO : parent) {
            List<ComChildVO> children = commentMapper.getCommentChildren(commentVO.getId());
            UserEntity userInfo = userMapper.getLoginInfo(commentVO.getFrom_id()); //父亲拿的用户信息
            for (ComChildVO comChildVO : children) {
                UserEntity fromUser = userMapper.getLoginInfo(comChildVO.getFrom_id()); //回复者的用户信息
                UserEntity toUser = userMapper.getLoginInfo(comChildVO.getTo_id()); //被回复者的用户信息
                comChildVO.setFrom_username(fromUser.getNickname());
                comChildVO.setTo_username(toUser.getNickname());
                comChildVO.setFrom_userHead(fromUser.getHead_picture());
            }
            commentVO.setChildren(children);
            commentVO.setUsername(userInfo.getNickname());
            commentVO.setUserHead(userInfo.getHead_picture());
            commentVO.setUserArea(userInfo.getArea());
        }
        return parent;
    }
}
