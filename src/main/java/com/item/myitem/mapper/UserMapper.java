package com.item.myitem.mapper;

import com.item.myitem.entity.FriendsEntity;
import com.item.myitem.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from com_user")
    List<UserEntity> getUserInfo();

    @Select("select * from com_user\n" +
            "where id = #{id};")
    UserEntity getLoginInfo(Integer id);

    @Select("select * from com_user where com_user.tel=#{tel} and password=#{password}")
    UserEntity getUserById(String tel,String password);

    @Insert("insert into friends(from_id,to_id) values (#{from_id},#{to_id})")
    void addFriend(Integer from_id,Integer to_id);

    @Select("select to_id from friends where from_id = #{from_id} and to_id = #{to_id} ")
    Integer sameFriend(Integer from_id, Integer to_id);

    //查找好友数量
    @Select("select count(*) from friends where from_id = #{from_id} ")
    Integer friendCnt(Integer from_id);

    //按名字搜索用户
    @Select("select * from com_user where nickname like concat('%',#{name},'%') ")
    List<UserEntity> selectByName(String name);
}
