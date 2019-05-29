package com.xh.jwt.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.jwt.user.entity.User;
import com.xh.jwt.user.repository.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JwtUser loadUserByUsername(String mobile) throws UsernameNotFoundException {
        User queryUser = new User();
        queryUser.setMobile(mobile);
        User user = userMapper.selectOne(new QueryWrapper<>(queryUser));
        if (user == null) {
            log.warn("user not fund...");
            return null;
        } else {
            JwtUser jwtUser = new JwtUser();
            jwtUser.setImToken(user.getToken());
            jwtUser.setMobile(user.getMobile());
            jwtUser.setAccId(user.getAccid());
            jwtUser.setId(user.getId());
            return jwtUser;
        }
    }

}
