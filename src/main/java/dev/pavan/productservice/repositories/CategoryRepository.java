package dev.pavan.productservice.repositories;


import dev.pavan.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository
extends JpaRepository<Category, UUID> {
    @Override
    List<Category> findAll();

    Optional<Category> findById(UUID uuid);

    @Override
    List<Category> findAllById(Iterable<UUID> uuids);
}
