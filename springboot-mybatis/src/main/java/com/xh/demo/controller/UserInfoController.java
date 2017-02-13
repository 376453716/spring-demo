package com.xh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xiong Hao
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("/list")
    @ResponseBody
    String list() {
        return "{}";
    }
}
