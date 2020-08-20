package com.zglu.api.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zglu.api.common.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zglu
 */
@Api(tags = "2.接口异常")
@ApiSupport(order = 2)
@RestControllerMapping("/exception")
public class ExceptionController {

    @GetMapping("/business")
    @ApiOperation("1.业务异常")
    @ApiOperationSupport(order = 1)
    public Result<Void> business() {
        MyAssert.isTrue(false, ResultCode.BUSINESS_ERROR);
        return Result.success(null);
    }

    @GetMapping("/server")
    @ApiOperation("2.服务器异常")
    @ApiOperationSupport(order = 2)
    public Result<Void> server() {
        int i = 1 / 0;
        return Result.success(null);
    }
}
