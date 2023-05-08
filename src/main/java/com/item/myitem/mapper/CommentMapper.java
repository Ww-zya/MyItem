package com.item.myitem.mapper;

import com.item.myitem.entity.CommentEntity;
import com.item.myitem.vo.ComChildVO;
import com.item.myitem.vo.CommentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(posts_id,content,from_id,to_id,parent_id) " +
            "VALUES(#{posts_id},#{content},#{from_id},#{to_id},#{parent_id});")
    void insertPost(Integer posts_id,String content,Integer from_id,Integer to_id,Integer parent_id);

    @Select("select * from comment where posts_id=#{posts_id} and parent_id is null;")
    List<CommentVO> getPostComment(Integer posts_id);

    @Select("select * from comment where parent_id=#{parent_id};")
    List<ComChildVO> getCommentChildren(Integer parent_id);
}
