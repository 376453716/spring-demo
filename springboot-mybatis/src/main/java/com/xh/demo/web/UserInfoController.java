package com.xh.demo.web;

import com.xh.demo.domain.UserInfo;
import com.xh.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Xiong Hao
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger("UserInfoController");

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/list")
    @ResponseBody
    public List<UserInfo> list(UserInfo userInfo) {
        return userInfoService.listUserInfo(userInfo);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public UserInfo get(@PathVariable Long id) {
        return userInfoService.getUserInfo(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String controllerExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("---ControllerException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return "000001";
    }
}

