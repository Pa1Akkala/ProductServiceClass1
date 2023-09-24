package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);
}
