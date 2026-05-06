package com.memm.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello from user-service!";
    }
}
