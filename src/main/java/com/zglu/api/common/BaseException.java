package com.zglu.api.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常，不符合业务抛出异常，由拦截器处理
 *
 * @author zglu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1837356253225335833L;
    private final int status;
    private final String message;
    private final String tips;

    public BaseException(ResultCode code) {
        this.status = code.getStatus();
        this.message = code.getMessage();
        this.tips = code.getTips();
    }

    public BaseException(ResultCode code, String tips) {
        this.status = code.getStatus();
        this.message = code.getMessage();
        this.tips = tips;
    }
}