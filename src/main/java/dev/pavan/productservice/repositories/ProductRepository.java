package dev.pavan.productservice.repositories;


import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.models.Category;
import dev.pavan.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository
extends JpaRepository<Product, UUID> {
     @Override
     Product save(Product product);

     Optional<Product> findByUuid(UUID uuid);

     @Override
     List<Product> findAll();

     List<Product> findAllByCategoryUuid(UUID uuid);

     List<Product> findAllByCategoryIn(List<Category> categories);

}
