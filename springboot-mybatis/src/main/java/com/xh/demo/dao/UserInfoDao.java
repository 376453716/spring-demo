package com.xh.demo.dao;

import com.xh.demo.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiong Hao
 */
@Mapper
public interface UserInfoDao {
    @Select("SELECT * FROM TB_ORG")
    List<UserInfo> listUserInfo(UserInfo userInfo);

    @Select("SELECT * FROM TB_ORG WHERE ID = #{id}")
    UserInfo getUserInfo(Long id);
}
