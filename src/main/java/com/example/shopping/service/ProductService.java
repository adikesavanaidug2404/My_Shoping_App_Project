package com.example.shopping.service;


import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        logger.info("Saving product: {}", product.getName());
        return productRepository.save(product);
    }

    public Product getProductById(int id) {
        logger.info("Fetching product by id: {}", id);
        return productRepository.findById(id).orElse(null);
    }
}