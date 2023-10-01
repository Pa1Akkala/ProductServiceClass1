package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    GenericProductDto getProductById(String uuid) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(String uuid) throws NotFoundException;

    GenericProductDto updateProduct(String uuid,GenericProductDto product);

    List<GenericProductDto> getAllProductsByCategory(String uuid);
}
