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
    REQUEST_ERROR(400, null, "请升级客户端"),
    SERVER_ERROR(500, null, "服务器异常，请联系管理员"),
    BUSINESS_ERROR(10000, "业务异常", "不允许的操作"),

    SUCCESS(200, "成功", "成功");

    private int status;
    private String message;
    private String tips;

    ResultCode(int status, String message, String tips) {
        this.status = status;
        this.message = message;
        this.tips = tips;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTips() {
        return tips;
    }
}