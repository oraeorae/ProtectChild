package com.example.protect2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Orall
 * @version 1.0
 * @description
 * @data 2022-9-11
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "SpringBoot";
    }

    @GetMapping("/cs")
    public Map<String,String> cs() {
        Map<String,String> map = new HashMap<>();
        map.put("msg","cs");
        return map;
    }

}
