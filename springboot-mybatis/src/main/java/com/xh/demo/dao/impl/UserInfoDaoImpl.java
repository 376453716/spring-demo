package com.xh.demo.dao.impl;

import com.xh.demo.dao.UserInfoDao;
import com.xh.demo.domain.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xiong Hao
 */
@Component
public class UserInfoDaoImpl implements UserInfoDao {

    private final SqlSession sqlSession;

    @Override
    public List<UserInfo> listUserInfo() {
        return null;
    }
}
