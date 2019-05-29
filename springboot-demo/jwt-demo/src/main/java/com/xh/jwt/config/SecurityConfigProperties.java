package com.xh.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Xiong Hao
 */
@Data
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfigProperties {

    private String ignorePath;
}
