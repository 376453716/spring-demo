package com.xh.demo.spring.context.xml.bean;

import lombok.Data;

/**
 * @author Xiong Hao
 * @date 2019-05-29
 */
@Data
public class XmlService {

    private UserService userService;
    private String name;
    private String method;
}
