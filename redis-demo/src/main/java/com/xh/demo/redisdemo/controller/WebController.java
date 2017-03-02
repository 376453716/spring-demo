package com.xh.demo.redisdemo.controller;

import com.xh.demo.common.CommonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Xiong Hao
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("login")
    @ResponseBody
    public CommonMessage login(HttpServletRequest request) {
        //login token user
        //recent token timestamp
        //viewed:token item timestamp
        String sid = request.getSession().getId();
        redisTemplate.opsForHash().put("recent", sid, System.currentTimeMillis());
        redisTemplate.opsForHash().put("viewed:" + sid, request.getRequestURI(), System.currentTimeMillis());
        return new CommonMessage();
    }

    @RequestMapping("list")
    @ResponseBody
    public CommonMessage list(HttpServletRequest request) {
        //login token user
        //recent token timestamp
        //viewed:token item timestamp
        String sid = request.getSession().getId();
        redisTemplate.opsForHash().put("recent", sid, System.currentTimeMillis());
        redisTemplate.opsForHash().put("viewed:" + sid, request.getRequestURI(), System.currentTimeMillis());
        return new CommonMessage();
    }

}
