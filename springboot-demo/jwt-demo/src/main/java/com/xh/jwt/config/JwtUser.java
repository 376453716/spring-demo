package com.xh.jwt.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @description:
 * @create: 2018-09-17 15:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户认证信息")
public class JwtUser implements UserDetails {

    @ApiModelProperty(value = "用戶ID", example = "100001")
    private Long id;

    @ApiModelProperty(value = "用戶网易云信ID", example = "accid1")
    private String accId;

    @ApiModelProperty(value = "用戶云信token", example = "token1")
    private String imToken;

    @ApiModelProperty(value = "mobile", example = "15000000001")
    private String mobile;

    @ApiModelProperty(value = "用户回话token", example = "eyJhbGciOiJIUzI1NiJ9.eyJhY2MiOiJhY2NpZDEiLCJ1aWQiOjIsIm1vYiI6IjE1MDAyODM2MzY0IiwiY3JlYXRlZCI6MTU1NDc4MDUyMTI5MSwiZXhwIjoxNTcwNTkxNzIxLCJpYXQiOjE1NTQ3ODA1MjF9.oL1DQBGHStQKHxRgh0ub-q1vh4Qp2JOAZ7ak2o00t1g")
    private String authToken;

    @JsonIgnore
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return accId;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return mobile;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}