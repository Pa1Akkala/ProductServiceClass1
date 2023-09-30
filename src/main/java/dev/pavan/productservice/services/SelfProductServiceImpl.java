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


@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        Optional<Product> productOptional=productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new NotFoundException("Product not found");
        }

        Product product=productOptional.get();
        GenericProductDto genericProductDto=convertProductIntoGenericProduct(product);
        return genericProductDto;

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        Product product1 = new Product();
        productRepository.save(convertGenericProductIntoProduct(product));
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
    public GenericProductDto deleteProduct(Long id) {
        Optional<Product> productOptional=productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product=productOptional.get();
            productRepository.delete(product);
            return convertProductIntoGenericProduct(product);
        }
        else{
            return null;
        }
    }

    @Override
    public GenericProductDto updateProduct(Long id,GenericProductDto product) {

        Optional<Product> productOptional=productRepository.findById(id);

        if(productOptional.isPresent()){
            Product product1=productOptional.get();
            convertGenericProductIntoProduct(product);
            productRepository.save(product1);
        }
        else{
            Product product1=new Product();
            convertGenericProductIntoProduct(product);
            productRepository.save(product1);
        }

        return product;

    }

    @Override
    public List<GenericProductDto> getAllProductsByCategory(Long id) {
        List<Product> products=productRepository.findAllByCategory_Id(id);
        List<GenericProductDto> genericProductDtos=new ArrayList<>();
        for(Product product:products){
            genericProductDtos.add(convertProductIntoGenericProduct(product));
        }
        return genericProductDtos;
    }

    GenericProductDto convertProductIntoGenericProduct(Product product){
        GenericProductDto genericProductDto=new GenericProductDto();
        genericProductDto.setId(product.getId());
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
        product.getPrice().setPrice(genericProductDto.getPrice());
        product.getCategory().setName(genericProductDto.getCategory());
        return product;
    }



}
