package com.xh.demo.dao;

import com.xh.demo.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiong Hao
 */
@Mapper
public interface UserInfoDao {
    @Select("SELECT name orgName,id,birthday createTime,id age FROM user")
    List<UserInfo> listUserInfo(UserInfo userInfo);

    @Select("SELECT * FROM TB_ORG WHERE ID = #{id}")
    UserInfo getUserInfo(Long id);

    @Insert("insert into user  (name,age,birthday) VALUES (#{orgName},#{id},#{createTime})")
    void addUserInfo(UserInfo userInfo);
}
