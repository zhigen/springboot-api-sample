package com.zglu.api.common;

/**
 * 自定义断言，不满足抛出业务异常
 *
 * @author zglu
 */
public class MyAssert {
    private MyAssert() {
    }

    public static void isTrue(boolean expression, ResultCode code) {
        if (!expression) {
            throw new BaseException(code);
        }
    }
}
