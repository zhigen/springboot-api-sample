package com.zglu.api.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolationException;

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

    public static void isTrue(boolean expression, ResultCode code, String tips) {
        if (!expression) {
            throw new BaseException(code, tips);
        }
    }

    public static void isEmpty(BindingResult bindingResult) {
        FieldError error = bindingResult.getFieldErrors().stream().findFirst().orElse(null);
        if (error != null) {
            throw new ConstraintViolationException(error.getField() + ":" + error.getDefaultMessage(), null);
        }
    }
}
