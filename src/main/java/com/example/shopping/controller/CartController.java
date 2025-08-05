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
        return cartService.addToCart(cartId, productId);
    }

    @GetMapping("/{cartId}")
        return cartService.getCart(cartId);
    }

    @PostMapping("/{cartId}/checkout")
        cartService.checkout(cartId);
        return "Checked out successfully!";
    }
// CartController removed to eliminate cart feature and related errors.
}
