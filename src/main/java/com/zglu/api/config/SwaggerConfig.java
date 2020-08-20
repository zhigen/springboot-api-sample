package com.zglu.api.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口文档配置
 * EnableKnife4j 开启Knife4j提供的增强功能，文档方可勾选启用，接口排序方可生效
 *
 * @author zglu
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("文档标题")
                .description("文档描述")
                .contact(new Contact("作者名称", "作者主页", "作者邮箱"))
                .version("版本")
                .termsOfServiceUrl("对外域名")
                .build();
    }

    @Bean
    public Docket docket(ApiInfo apiInfo) {
        // 添加通用请求参数
        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(new ParameterBuilder().parameterType("header").modelRef(new ModelRef("string")).name("token").description("认证").build());

        // 定义通用响应状态
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(400).message("4XX为错误的请求，请检查客户端").responseModel(new ModelRef("统一响应«Void»")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("5XX为服务器异常，请联系管理员").responseModel(new ModelRef("统一响应«Void»")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(10000).message("XXXXX为业务异常，请查看提示信息").responseModel(new ModelRef("统一响应«Void»")).build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameterList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .globalResponseMessage(RequestMethod.PATCH, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .apiInfo(apiInfo)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.zglu.api.controller"))
                .build();
    }
}