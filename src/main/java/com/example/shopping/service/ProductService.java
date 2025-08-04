package com.example.shopping.service;

import com.example.shopping.model.Product;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getAllProducts() {
        return Arrays.asList(
            new Product() {{ setId(1); setName("Laptop"); setPrice(75000); }},
            new Product() {{ setId(2); setName("Smartphone"); setPrice(25000); }}
        );
    }
}