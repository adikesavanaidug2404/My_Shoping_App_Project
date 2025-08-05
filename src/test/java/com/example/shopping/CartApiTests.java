package com.example.shopping;

import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CartApiTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddToCartAndCheckout() throws Exception {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(123.45);
        product = productRepository.save(product);

        // Add to cart
        String cartJson = mockMvc.perform(MockMvcRequestBuilders.post("/api/cart/1/add/" + product.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertTrue(cartJson.contains("Test Product"));

        // Checkout
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cart/1/checkout"))
                .andExpect(status().isOk())
                .andExpect(content().string("Checked out successfully!"));
    }
