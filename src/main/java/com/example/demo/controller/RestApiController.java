package com.example.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.DTO.ResponseApiRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/my-api-rest")
    public ResponseApiRest greeting(@RequestParam(value = "name", defaultValue = "World") String name,
                                    @RequestParam(value = "status", defaultValue = "true") Boolean status) {
        return new ResponseApiRest(counter.incrementAndGet(), String.format(template, name), status);
    }

}
