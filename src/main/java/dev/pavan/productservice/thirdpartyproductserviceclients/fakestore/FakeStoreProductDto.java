package dev.pavan.productservice.thirdpartyproductserviceclients.fakestore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private String uuid;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
