package com.xh.jwt.user;


import com.xh.jwt.user.entity.User;

/**
 * @author Xiong Hao
 */
public interface UserService {

    User queryUser(String mobile);

}
