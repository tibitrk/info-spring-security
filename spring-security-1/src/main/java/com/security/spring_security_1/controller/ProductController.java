package com.security.spring_security_1.controller;

import com.security.spring_security_1.model.Product;
import com.security.spring_security_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save-product")
    public Product createProduct(@RequestBody Product product){
       return productService.saveProduct(product);
    }
    @GetMapping("/get-product")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
}
