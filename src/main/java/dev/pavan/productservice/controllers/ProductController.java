package dev.pavan.productservice.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public String getAllProducts() {
        return "No products as of now";
    }

    // localhost:8080/products/{id}
    // localhost:8080/products/123
    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id) {
        return "Here is product id: " + id;
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id")Long id) {

    }

    @PostMapping
    public String createProduct() {
        return "Created new product with id : " + UUID.randomUUID();
    }

    @PutMapping("{id}")
    public void updateProductById() {

    }

}
