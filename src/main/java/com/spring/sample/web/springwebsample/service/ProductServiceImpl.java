package com.spring.sample.web.springwebsample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sample.web.springwebsample.model.entity.Product;
import com.spring.sample.web.springwebsample.repository.ProductRepository;

@Service
public class ProductServiceImpl {
    
    @Autowired
    ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        
        this.productRepository.findAll().forEach(products::add);
        
        return products;
    }
    
    public List<Product> getByProductName(String name) {
        List<Product> products = new ArrayList<>();
        
        this.productRepository.findByProductName(name).forEach(products::add);
        
        return products;
    }
    
    public void addProduct(String productName) {
        Product product = new Product();
        
        product.setProductName(productName);
        
        productRepository.save(product);
    }
}
