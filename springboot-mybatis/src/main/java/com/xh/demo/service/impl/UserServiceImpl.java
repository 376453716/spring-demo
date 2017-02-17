package com.xh.demo.service.impl;

import com.xh.demo.common.MessageProperties;
import com.xh.demo.dao.UserInfoDao;
import com.xh.demo.domain.UserInfo;
import com.xh.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiong Hao
 */
@Service
public class UserServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public List<UserInfo> listUserInfo(UserInfo userInfo) {

        return userInfoDao.listUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        return userInfoDao.getUserInfo(id);
    }
}
