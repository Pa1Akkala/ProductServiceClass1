package dev.pavan.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name="categories")
public class Category extends BaseModel{
    private String name;
}
