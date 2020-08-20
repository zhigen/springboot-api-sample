package com.zglu.api.common;

/**
 * 响应状态
 *
 * @author zglu
 */
public enum ResultCode {
    /**
     * 通用
     */
    SERVER_ERROR(500, "服务器异常，请联系管理员"),

    BUSINESS_ERROR(10000, "业务异常"),

    SUCCESS(200, "请求成功");

    private int status;
    private String message;

    ResultCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}