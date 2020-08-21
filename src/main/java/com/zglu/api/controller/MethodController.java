package com.zglu.api.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.zglu.api.common.RestControllerMapping;
import com.zglu.api.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 定义http常用的资源操作行为
 *
 * @author zglu
 */
@Api(tags = "4. 请求行为")
@ApiSupport(order = 4)
@RestControllerMapping("/method")
public class MethodController {

    @PostMapping
    @ApiOperation("1. 提交数据")
    @ApiOperationSupport(order = 1)
    public Result<InputDto> post(@RequestBody InputDto dto) {
        return Result.success(dto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("2. 删除数据")
    @ApiOperationSupport(order = 2)
    public Result<Integer> delete(@PathVariable Integer id) {
        return Result.success(id);
    }

    @PatchMapping
    @ApiOperation("3. 修改数据")
    @ApiOperationSupport(order = 3)
    public Result<InputDto> patch(@RequestBody InputDto dto) {
        return Result.success(dto);
    }

    @GetMapping("/{id}")
    @ApiOperation("4. 请求数据，幂等")
    @ApiOperationSupport(order = 4)
    public Result<InputDto> get(@PathVariable Integer id) {
        return Result.success(null);
    }

    @GetMapping("s")
    @ApiOperation("5. 请求数据集合，复数，幂等")
    @ApiOperationSupport(order = 5)
    public Result<List<InputDto>> get() {
        return Result.success(null);
    }

    @PutMapping
    @ApiOperation("6. 覆盖数据，幂等")
    @ApiOperationSupport(order = 6)
    public Result<InputDto> put(@RequestBody InputDto dto) {
        return Result.success(dto);
    }

}
