package com.spring.sample.web.springwebsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sample.web.springwebsample.model.Hello;
import com.spring.sample.web.springwebsample.service.ProductServiceImpl;

@Controller
@RequestMapping("/login")
public class HelloController {
    
    ProductServiceImpl service;
    
    @Autowired
    public HelloController(ProductServiceImpl service) {
        this.service = service;
    }
    
    @GetMapping("/loginPage/{value}")
    public String getLogin(@PathVariable("value") String value, Model model) {
        Hello hello = new Hello("hello", "world");
        model.addAttribute("hello", hello);
        model.addAttribute("value", value);
        model.addAttribute("products", service.getAllProducts());
        return "login";
    }
}
