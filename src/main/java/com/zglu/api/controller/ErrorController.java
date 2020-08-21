package com.zglu.api.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zglu.api.common.MyAssert;
import com.zglu.api.common.RestControllerMapping;
import com.zglu.api.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;

/**
 * @author zglu
 */
@Validated
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

    @GetMapping("/400")
    @ApiOperation("3. 400，可通过postman或浏览器请求时不传入参数或传入错误格式参数实现")
    @ApiOperationSupport(order = 3)
    public Result<Integer> e400(@ApiParam(value = "整数", required = true) @Min(value = 1) @RequestParam Integer i) {
        return Result.success(i, "自定义的成功提示");
    }

    @PostMapping("/400")
    @ApiOperation("4. 400，测试传入参数对象验证")
    @ApiOperationSupport(order = 4)
    public Result<InputDto> e400(@Validated @RequestBody InputDto dto, BindingResult bindingResult) {
        MyAssert.isEmpty(bindingResult);
        return Result.success(dto, "自定义的成功提示");
    }

}
