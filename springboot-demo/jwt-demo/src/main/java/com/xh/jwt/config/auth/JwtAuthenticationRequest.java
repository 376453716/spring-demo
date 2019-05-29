package com.xh.jwt.config.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("登录注册请求对象")
public class JwtAuthenticationRequest {

    @ApiModelProperty(value = "手机号", required = true, example = "+852-88888888")
    private String mobile;

    @ApiModelProperty(value = "验证码", required = true, example = "1234")
    private String verifycode;

}
