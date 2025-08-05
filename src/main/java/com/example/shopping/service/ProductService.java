package com.example.shopping.service;


import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;


    // Demo: Return hardcoded products with images if DB is empty
    public List<Product> getAllProducts() {
        logger.info("Fetching all products");
        List<Product> products = productRepository.findAll();
        if (products == null || products.isEmpty()) {
            String placeholder = "https://via.placeholder.com/64?text=Product";
            Product p1 = new Product();
            p1.setId(1);
            p1.setName("Apple iPhone 15");
            p1.setPrice(999.99);
            p1.setImageUrl(placeholder);

            Product p2 = new Product();
            p2.setId(2);
            p2.setName("Samsung Galaxy S24");
            p2.setPrice(899.99);
            p2.setImageUrl(placeholder);

            Product p3 = new Product();
            p3.setId(3);
            p3.setName("Sony WH-1000XM5 Headphones");
            p3.setPrice(349.99);
            p3.setImageUrl(placeholder);

            Product p4 = new Product();
            p4.setId(4);
            p4.setName("Apple MacBook Air M2");
            p4.setPrice(1199.99);
            p4.setImageUrl(placeholder);

            return Arrays.asList(p1, p2, p3, p4);
        }
        return products;
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