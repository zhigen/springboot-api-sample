package com.zglu.api.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zglu
 */
@Data
@ApiModel("传入参数对象")
public class InputDto {
    @ApiModelProperty("名称")
    @NotNull(message = "名称不能为空")
    private String name;
    @NotNull
    private Integer age;
}
