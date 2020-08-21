package com.zglu.api.config;

import com.zglu.api.common.BaseException;
import com.zglu.api.common.Result;
import com.zglu.api.common.ResultCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 拦截控制器异常统一处理
 *
 * @author zglu
 */
@Log4j2
@RestControllerAdvice("com.zglu.api")
public class MyExceptionHandler {

    /**
     * 拦截控制器抛出业务异常
     *
     * @param e 业务异常
     * @return 统一响应
     */
    @ExceptionHandler(BaseException.class)
    public Result<Void> baseException(BaseException e) {
        log.warn("业务异常", e);
        return Result.error(e);
    }

    /**
     * 拦截控制器抛出参数异常
     *
     * @param e 参数异常
     * @return 统一响应
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
    public Result<Void> requestException(Exception e) {
        log.warn("错误请求", e);
        return Result.error(ResultCode.REQUEST_ERROR, e);
    }

    /**
     * 拦截控制器抛出未知异常
     *
     * @param e 未知异常
     * @return 统一响应
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> exception(Exception e) {
        log.error("服务器异常", e);
        return Result.error(e);
    }
}