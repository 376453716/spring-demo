package com.xh.jwt.common;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @description:
 **/
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Bean
    public Docket api(ApiInfo apiInfo) {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfo);
        ApiSelectorBuilder builder = docket.select();
        builder.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class));
        docket = builder.paths(PathSelectors.any()).build().securitySchemes(newArrayList(
                new ApiKey("token", "Authorization", "header")
        ));
        /*  return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());*/

        return docket;
    }


    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfo(
                "jwt Server",
                "app接口服务,请求认证接口,需在header中添加Authorization",
                "1.0.0",
                "test",
                new Contact("admin", "admin", ""),
                "License of API", "API license URL", Collections.emptyList());
    }
}