package com.spring.sample.web.springwebsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.sample.web.springwebsample.model.Hello;
import com.spring.sample.web.springwebsample.service.ProductServiceImpl;

@Controller
public class HelloController {
    
    ProductServiceImpl service;
    
    @Autowired
    public HelloController(ProductServiceImpl service) {
        this.service = service;
    }
    
    @GetMapping("/login/{value}")
    public String getLogin(@PathVariable("value") String value, Model model) {
        Hello hello = new Hello("hello", "world");
        model.addAttribute("hello", hello);
        model.addAttribute("value", value);
        model.addAttribute("products", service.getAllProducts());
        return "login";
    }
    
    @GetMapping("/product/add")
    public String addProduct(@RequestParam("product") String productName, Model model) {
        service.addProduct(productName);
        model.addAttribute("products", service.getAllProducts());        
        return "product";
    }
    
    @GetMapping("/exception")
    public String generateException() {
        throw new NullPointerException();
    }
}
