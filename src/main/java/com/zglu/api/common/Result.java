package com.zglu.api.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zglu
 */
@Data
@Accessors(chain = true)
@ApiModel("统一响应")
public class Result<T> {
    @ApiModelProperty("响应状态")
    private int status;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("响应数据")
    private T data;

    public static <T> Result<T> success(T t) {
        return new Result<T>().setStatus(200).setMessage("成功").setData(t);
    }
}