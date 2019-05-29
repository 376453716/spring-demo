package com.xh.jwt.user;

import com.xh.jwt.common.ResponseResult;
import com.xh.jwt.config.JwtUser;
import com.xh.jwt.config.SecurityUserUtils;
import com.xh.jwt.config.auth.JwtAuthenticationRequest;
import com.xh.jwt.config.auth.TokenBasedAuthentication;
import com.xh.jwt.config.auth.TokenHelper;
import com.xh.jwt.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@Api(value = "用户登录接口", tags = "用户登录接口", description = "用户登录接口")
@RestController
@RequestMapping(value = "/auth")
@Slf4j
public class AuthenticationController {

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private UserService userService;


    @ApiOperation("登陆获取token")
    @PostMapping(value = "/login")
    public ResponseResult<JwtUser> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        User user = userService.queryUser(authenticationRequest.getMobile());
        if (user == null) {
            log.info("user is null...");
            throw new AuthenticationCredentialsNotFoundException("user is null");
        }
        //查询用户是否注册，
        JwtUser jwtUser = new JwtUser();
        jwtUser.setId(user.getId());
        jwtUser.setAccId(user.getAccid());
        jwtUser.setMobile(user.getMobile());
        jwtUser.setImToken(user.getToken());
        Authentication authentication = new TokenBasedAuthentication(jwtUser);
        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jws = tokenHelper.generateToken(jwtUser);
        jwtUser.setAuthToken(jws);
        // Return the token
        return new ResponseResult<>(jwtUser);
    }

    @ApiOperation("登陆用户信息")
    @GetMapping("/getUser")
    public ResponseResult<User> getUserInfo() {
        return new ResponseResult<>(userService.queryUser(SecurityUserUtils.getMobile()));
    }

}