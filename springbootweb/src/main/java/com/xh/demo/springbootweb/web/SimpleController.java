package com.xh.demo.springbootweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Xiong Hao
 */
@Controller
@RequestMapping("web")
public class SimpleController {

    @RequestMapping("/list")
    public String list() {
        return "test";
    }
}
