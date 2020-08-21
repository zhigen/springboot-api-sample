package com.zglu.api.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

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
    @ApiModelProperty("响应提示")
    private String tips;
    @ApiModelProperty("响应数据")
    private T data;
    @ApiModelProperty("错误原因")
    private String error;
    @ApiModelProperty("错误堆栈")
    private Object trace;

    public Result(ResultCode code) {
        status = code.getStatus();
        message = code.getMessage();
        tips = code.getTips();
    }

    public Result(BaseException e) {
        status = e.getStatus();
        message = e.getMessage();
        tips = e.getTips();
    }

    public static <T> Result<T> success(T t) {
        return new Result<T>(ResultCode.SUCCESS).setData(t);
    }

    public static <T> Result<T> success(T t, String tips) {
        return new Result<T>(ResultCode.SUCCESS).setData(t).setTips(tips);
    }

    public static <T> Result<T> error(BaseException e) {
        return new Result<T>(e).setError(e.getClass().getTypeName()).setTrace(e.getStackTrace());
    }

    public static <T> Result<T> error(Exception e) {
        return new Result<T>(ResultCode.SERVER_ERROR).setMessage(e.getMessage()).setError(e.getClass().getTypeName()).setTrace(e.getStackTrace());
    }

    public static <T> Result<T> error(ResultCode code, Exception e) {
        return new Result<T>(code).setMessage(e.getMessage()).setError(e.getClass().getTypeName()).setTrace(e.getStackTrace());
    }

    public static <T> Result<T> error(Map<String, Object> m) {
        return new Result<T>(ResultCode.REQUEST_ERROR)
                .setStatus(Integer.parseInt(m.get("status") + ""))
                .setMessage(m.get("message") + "")
                .setError(m.get("error") + "")
                .setTrace(m.get("trace"));
    }
}