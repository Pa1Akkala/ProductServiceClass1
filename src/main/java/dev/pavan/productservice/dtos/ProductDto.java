package dev.pavan.productservice.dtos;

import dev.pavan.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String title;

    private String description;

    private String image;
    //            P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans:    m : 1
    private Price price;
}
