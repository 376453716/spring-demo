package com.xh.jwt.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.jwt.user.UserService;
import com.xh.jwt.user.entity.User;
import com.xh.jwt.user.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Xiong Hao
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(String mobile) {
        User user = new User();
        user.setMobile(mobile);
        return userMapper.selectOne(new QueryWrapper<>(user));
    }

}
