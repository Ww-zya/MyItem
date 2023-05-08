package com.item.myitem.mapper;

import com.item.myitem.dto.PostsDTO;
import com.item.myitem.entity.PostsEntity;
import com.item.myitem.entity.SquareInfoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostsMapper {
    @Select("select cu.id as userId, cu.nickname as nickname, cu.head_picture as head,p.posts_id as postsId, p.posts_title as title, p.posts_content as content, p.posts_time as time\n" +
            "from posts p inner join special_area sa on p.area_id = sa.area_id\n" +
            "inner join com_user cu on p.user_id = cu.id")
    List<SquareInfoEntity> getSquareInfo();

    @Insert("insert into posts(user_id,posts_title,posts_content) VALUES(#{id},#{title},#{content})")
    void insertPosts(Integer id, String title, String content);

    @Select("select * from posts where posts_id = #{postsId};")
    PostsEntity getPostsInfo(Integer postsId);
}
