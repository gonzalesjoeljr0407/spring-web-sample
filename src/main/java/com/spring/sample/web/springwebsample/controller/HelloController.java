package com.spring.sample.web.springwebsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sample.web.springwebsample.model.Hello;

@Controller
@RequestMapping("/login")
public class HelloController {
    
    @GetMapping("/loginPage/{value}")
    public String getLogin(@PathVariable("value") String value, Model model) {
        Hello hello = new Hello("hello", "world");
        model.addAttribute("hello", hello);
        model.addAttribute("value", value);
        return "login";
    }
}
