package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericCategoryDto;
import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.models.Category;

import java.util.List;

public interface CategoryService {

    public List<GenericCategoryDto> getAllCategories();

    Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);

}
