package dev.pavan.productservice.services;

import dev.pavan.productservice.dtos.GenericProductDto;
import dev.pavan.productservice.exceptions.NotFoundException;
import dev.pavan.productservice.models.Category;
import dev.pavan.productservice.models.Price;
import dev.pavan.productservice.models.Product;
import dev.pavan.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public GenericProductDto getProductById(String uuid) throws NotFoundException {
        Optional<Product> productOptional=productRepository.findByUuid(UUID.fromString(uuid));
        if(productOptional.isEmpty()){
            throw new NotFoundException("Product not found");
        }

        Product product=productOptional.get();
        GenericProductDto genericProductDto=convertProductIntoGenericProduct(product);
        return genericProductDto;

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        Product savedProduct=productRepository.save(convertGenericProductIntoProduct(product));

        //After saving the product, we need to set the id of the product in the genericProductDto.
        // Then only we can see the id in the response.
        product.setUuid(savedProduct.getUuid().toString());
        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products=productRepository.findAll();
        List<GenericProductDto> genericProductDtos=new ArrayList<>();
        for(Product product:products){
            genericProductDtos.add(convertProductIntoGenericProduct(product));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(String uuid) throws NotFoundException {
        Optional<Product> productOptional=productRepository.findByUuid(UUID.fromString(uuid));
        if(productOptional.isPresent()){
            Product product=productOptional.get();
            productRepository.delete(product);
            return convertProductIntoGenericProduct(product);
        }
        else{
            throw new NotFoundException("Product not found");
        }
    }

    @Override
    public GenericProductDto updateProduct(String uuid,GenericProductDto product) {

        Optional<Product> productOptional=productRepository.findByUuid(UUID.fromString(uuid));

        if(productOptional.isPresent()){
            Product exisProduct=productOptional.get();
            exisProduct.setImage(product.getImage());
            exisProduct.setDescription(product.getDescription());
            exisProduct.setTitle(product.getTitle());

            //Setting the price
            Price price=exisProduct.getPrice();   //Getting the price object from the existing product
            price.setPrice(product.getPrice());   //Setting the price
            exisProduct.setPrice(price);          //Setting the price object to the existing product

            //Setting the Category
            Category category=exisProduct.getCategory();  //Getting the category object from the existing product
            category.setName(product.getCategory());      //Setting the category
            exisProduct.setCategory(category);            //Setting the category object to the existing product

            Product savedProduct=productRepository.save(exisProduct);

            return convertProductIntoGenericProduct(savedProduct);
        }
        else{
            Product savedProduct = productRepository.save(convertGenericProductIntoProduct(product));
            product.setUuid(savedProduct.getUuid().toString());
        }

        return product;


    }

    @Override
    public List<GenericProductDto> getAllProductsByCategory(String uuid) {
        List<Product> products=productRepository.findAllByCategoryUuid(UUID.fromString(uuid));
        List<GenericProductDto> genericProductDtos=new ArrayList<>();
        for(Product product:products){
            genericProductDtos.add(convertProductIntoGenericProduct(product));
        }
        return genericProductDtos;
    }

    GenericProductDto convertProductIntoGenericProduct(Product product){
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setUuid(product.getUuid().toString());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setDescription(product.getDescription());
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setPrice(product.getPrice().getPrice());
        genericProductDto.setCategory(product.getCategory().getName());
        return genericProductDto;
    }

    Product convertGenericProductIntoProduct(GenericProductDto genericProductDto){
        Product product=new Product();
        product.setImage(genericProductDto.getImage());
        product.setDescription(genericProductDto.getDescription());
        product.setTitle(genericProductDto.getTitle());

        //Setting the price
        Price price=new Price();
        price.setPrice(genericProductDto.getPrice());
        product.setPrice(price);

        //Setting the Category
        Category category=new Category();
        category.setName(genericProductDto.getCategory());
        product.setCategory(category);


        return product;
    }



}
