package com.spring.sample.web.springwebsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class HelloController {
    
    @GetMapping("/loginPage")
    public String getLogin() {
        return "login";
    }
}
