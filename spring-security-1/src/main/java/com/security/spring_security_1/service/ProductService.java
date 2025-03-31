package com.security.spring_security_1.service;

import com.security.spring_security_1.model.Product;
import com.security.spring_security_1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
       return productRepository.save(product);
    }
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
}
