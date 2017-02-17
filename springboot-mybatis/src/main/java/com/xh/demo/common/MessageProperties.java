package com.xh.demo.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Xiong Hao
 */
@ConfigurationProperties("com.xh")
public class MessageProperties {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}