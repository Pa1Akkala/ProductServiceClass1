package dev.pavan.productservice.controllers;

import dev.pavan.productservice.dtos.GenericCategoryDto;
import dev.pavan.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    public CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<GenericCategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
