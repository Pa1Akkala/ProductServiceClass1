package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

    GenericProductDto updateProduct(Long id,GenericProductDto product);

    List<GenericProductDto> getAllProductsByCategory(Long id);
}
