package com.xh.demo.web;

import com.xh.demo.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author Xiong Hao
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("/list")
    @ResponseBody
    UserInfo list() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setBirthday(new Date());
        userInfo.setEmail("x376453716@gmail.com");
        userInfo.setName("xiongh");
        return userInfo;
    }
}
