package dev.pavan.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    //            P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans:    m : 1
    @ManyToOne(cascade = {CascadeType.PERSIST})
    //@Fetch(FetchMode.SUBSELECT)
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
            //fetch = FetchType.LAZY)
//    @Fetch(FetchMode.JOIN)
    private Price price;
//    private double price;
}
