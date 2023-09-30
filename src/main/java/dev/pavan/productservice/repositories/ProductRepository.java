package dev.pavan.productservice.repositories;


import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository
extends JpaRepository<Product, Long> {
     @Override
     Product save(Product product);

     @Override
     Optional<Product> findById(Long id);

     @Override
     List<Product> findAll();

     List<Product> findAllByCategory_Id(Long id);
}
