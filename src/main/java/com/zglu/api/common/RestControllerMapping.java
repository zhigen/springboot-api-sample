package com.zglu.api.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * RestController 与 RequestMapping 结合
 *
 * @author zglu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping
public @interface RestControllerMapping {
    @AliasFor(annotation = RequestMapping.class)
    String[] value() default {};
}