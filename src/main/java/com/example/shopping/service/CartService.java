
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

    public Cart addToCart(Long cartId, int productId) {
        logger.info("Adding product {} to cart {}", productId, cartId);
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cart.getProducts().add(product);
            cartRepository.save(cart);
        }
        return cart;
    }

    public Cart getCart(Long cartId) {
        logger.info("Fetching cart {}", cartId);
        return cartRepository.findById(cartId).orElse(null);
    }

    public void checkout(Long cartId) {
        logger.info("Checking out cart {}", cartId);
        cartRepository.deleteById(cartId);
    }
}
