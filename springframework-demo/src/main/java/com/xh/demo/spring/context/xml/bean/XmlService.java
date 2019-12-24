package com.xh.demo.spring.context.xml.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author Xiong Hao
 * @date 2019-05-29
 */
@Data
@Slf4j
public class XmlService implements BeanNameAware {

    private UserService userService;
    private String name;
    private String method;

    @Override
    public void setBeanName(String name) {
        log.info("name...{}", name);
    }
}
