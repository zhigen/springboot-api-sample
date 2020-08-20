package com.zglu.api.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zglu.api.common.RestControllerMapping;
import com.zglu.api.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zglu
 */
@Api(tags = "3. 接口错误")
@ApiSupport(order = 3)
@RestControllerMapping("/error")
public class ErrorController {

    @GetMapping("/404")
    @ApiOperation("1. 404，可通过修改接口路径实现")
    @ApiOperationSupport(order = 1)
    public Result<Void> e404() {
        return Result.success(null);
    }

    @PostMapping("/405")
    @ApiOperation("2. 405，可通过postman修改请求方法为get或通过浏览器地址栏请求实现")
    @ApiOperationSupport(order = 2)
    public Result<Void> e405() {
        return Result.success(null);
    }

}
