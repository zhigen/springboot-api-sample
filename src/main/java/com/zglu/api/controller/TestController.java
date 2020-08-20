package com.zglu.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zglu
 */
@RestController
public class TestController {

    @GetMapping
    public String helloWorld() {
        return "Hello World!";
    }
}
