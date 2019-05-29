###

##### jwt登录认证
1. 用户登录，交易用户信息，根据用户信息生成jwt Token。返回token
2. 用户认证，请求header中加入token，拦截器获取token，解析出用户身份信息，userDetailsService查询用户信息，校验用户信息与token信息，创建TokenBasedAuthentication认证信息。认证完成