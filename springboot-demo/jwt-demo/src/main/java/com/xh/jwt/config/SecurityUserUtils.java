package com.xh.jwt.config;

import com.xh.jwt.config.auth.TokenBasedAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Xiong Hao
 * @date 2019/4/9
 */
public class SecurityUserUtils {

    public static String getMobile() {
        TokenBasedAuthentication authentication = (TokenBasedAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getJwtUser().getMobile();
    }

    public static JwtUser getJwtUser() {
        TokenBasedAuthentication authentication = (TokenBasedAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return authentication.getJwtUser();
    }
}
