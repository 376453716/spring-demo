package com.xh.demo.springbootweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Xiong Hao
 */
@Controller
@RequestMapping("/web")
public class SimpleController {

    @RequestMapping("/list")
    @ResponseBody
    public Message list(Message message) {
        return new Message(message.getMessage());
    }
}
