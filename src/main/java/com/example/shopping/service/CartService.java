
package com.example.shopping.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.shopping.model.Cart;
import com.example.shopping.model.Product;
import com.example.shopping.repository.CartRepository;
import com.example.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;



// CartService removed to eliminate cart feature and related errors.
// CartService removed to eliminate cart feature and related errors.
