package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericProductDto;

public interface ProductService {
    GenericProductDto getProductById(Long id);
}
