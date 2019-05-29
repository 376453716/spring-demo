package com.xh.jwt.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Xiong Hao
 */
@Data
public class Constants {

    /**
     * 成功
     */
    public static final Integer SUCCESS_CODE = HttpStatus.OK.value();

    /**
     * 未认证
     */
    public static final Integer UNAUTHORIZED = HttpStatus.UNAUTHORIZED.value();

    /**
     * 未授权
     */
    public static final Integer FORBIDDEN = HttpStatus.FORBIDDEN.value();

    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_DATE = "yyyy-MM-dd";

    public static final String FORMAT_TIME = "HH:mm:ss";
}
