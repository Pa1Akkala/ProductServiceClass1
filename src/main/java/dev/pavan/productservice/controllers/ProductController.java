package dev.pavan.productservice.controllers;

import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.exceptions.NotFoundException;
import dev.pavan.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //    @Autowired
    // field injection
    private ProductService productService;
    // ....;
    // ...;


    // constructor injection

    public ProductController(@Qualifier("selfProductServiceImpl") ProductService productService) {
        this.productService = productService;
    }
//

    // setter injection
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    // GET /products {}
    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    // localhost:8080/products/{id}
    // localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
//        System.out.println(product.name);
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProduct(@PathVariable("id") Long id, @RequestBody GenericProductDto product) {
        return productService.updateProduct(id, product);
    }

    @GetMapping("/category/{id}")
    public List<GenericProductDto> getAllProductsByCategory(@PathVariable("id") Long id) {
        return productService.getAllProductsByCategory(id);
    }
}
