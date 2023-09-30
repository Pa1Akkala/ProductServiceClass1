package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericCategoryDto;
import dev.pavan.productservice.dtos.GenericProductDto;

import java.util.List;

public interface CategoryService {

    public List<GenericCategoryDto> getAllCategories();

}
