package dev.pavan.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="categories")
public class Category extends BaseModel{
    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
    // this is the same relation being mapped by category attribute in the other (Product) class
}
