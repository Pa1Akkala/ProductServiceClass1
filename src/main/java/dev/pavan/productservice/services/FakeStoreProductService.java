package dev.pavan.productservice.services;

import dev.pavan.productservice.thirdpartyproductserviceclients.fakestore.FakeStoreProductDto;
import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.exceptions.NotFoundException;
import dev.pavan.productservice.thirdpartyproductserviceclients.fakestore.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
        product.setUuid(fakeStoreProductDto.getUuid().toString());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }


    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto getProductById(String uuid) throws NotFoundException {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(uuid));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(String uuid) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProduct(uuid));
    }

    @Override
    public GenericProductDto updateProduct(String uuid, GenericProductDto product) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProductsByCategory(String uuid) {
        return null;
    }


}
