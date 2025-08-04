package com.example.shopping.controller;

import com.example.shopping.model.Cart;
import com.example.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}/add/{productId}")
    public Cart addToCart(@PathVariable Long cartId, @PathVariable int productId) {
        return cartService.addToCart(cartId, productId);
    }

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId);
    }

    @PostMapping("/{cartId}/checkout")
    public String checkout(@PathVariable Long cartId) {
        cartService.checkout(cartId);
        return "Checked out successfully!";
    }
}
