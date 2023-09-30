package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericCategoryDto;
import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.models.Category;
import dev.pavan.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelfCategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public SelfCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<GenericCategoryDto> getAllCategories() {
        List<Category> categories=categoryRepository.findAll();
        List<GenericCategoryDto> genericCategoryDtos=new ArrayList<>();
        for(Category category:categories){
            GenericCategoryDto genericCategoryDto=new GenericCategoryDto();
            genericCategoryDto.setId(category.getId());
            genericCategoryDto.setName(category.getName());
            genericCategoryDtos.add(genericCategoryDto);
        }

        return genericCategoryDtos;
    }
}
