package com.xh.demo.service.impl;

import com.xh.demo.common.MessageProperties;
import com.xh.demo.dao.UserInfoDao;
import com.xh.demo.domain.UserInfo;
import com.xh.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public void addUserInfo() {
        List<UserInfo> userInfoList = new ArrayList<>(9999999);
        for (int i = 0; i < 9999999; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setCreateTime(new Date());
            userInfo.setOrgName(UUID.randomUUID().toString());
            userInfo.setId(new Random(i).nextInt());
            userInfoList.add(userInfo);
            userInfoDao.addUserInfo(userInfo);
        }
    }
}
