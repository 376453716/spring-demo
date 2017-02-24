package com.xh.demo.web;

import com.xh.demo.domain.UserInfo;
import com.xh.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
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

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/list")
    @ResponseBody
    public List<UserInfo> list(UserInfo userInfo) {
        long start = System.currentTimeMillis();
        logger.info("start----");
        List<UserInfo> list = userInfoService.listUserInfo(userInfo);
        logger.info("list size==" + list.size());
        long time = System.currentTimeMillis() - start;
        logger.info("end----" + time);
        logger.info("===>" + dataSource.toString());
        return list;
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public UserInfo get(@PathVariable Long id) {
        return userInfoService.getUserInfo(id);
    }

    @RequestMapping("/init")
    @ResponseBody
    public String get() {
        userInfoService.addUserInfo();
        return "{retCode:000000,ret_message:success}";
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String controllerExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("---ControllerException Handler---Host {} invokes url {} ERROR: {}", req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return "{\"retCode\":\"000001\",\"ret_message\":\"success\"}";
    }
}

