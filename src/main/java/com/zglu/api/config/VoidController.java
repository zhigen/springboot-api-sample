package com.zglu.api.config;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zglu.api.common.RestControllerMapping;
import com.zglu.api.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 提供一个空接口，返回对象：统一响应«Void»，以便文档通用响应状态配置中的响应参数可引用此返回对象
 * {@link com.zglu.api.config.SwaggerConfig}
 *
 * @author zglu
 */
@Api(tags = "1.接口配置")
@ApiSupport(order = 1)
@RestControllerMapping(value = "/void")
public class VoidController {

    @GetMapping
    @ApiOperation("1.定义统一响应")
    @ApiOperationSupport(order = 1)
    public Result<Void> none() {
        return Result.success(null);
    }
}
