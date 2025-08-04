package com.example.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ViewController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
}
