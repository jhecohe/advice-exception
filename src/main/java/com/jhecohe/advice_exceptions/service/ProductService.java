package com.jhecohe.advice_exceptions.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jhecohe.advice_exceptions.model.Product;
import com.jhecohe.advice_exceptions.repository.ProductRepository;

@Service
public class ProductService {

    ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) throws Exception {
        product.setCreated(LocalDate.now());
        return productRepository.addProduct(product);
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Product getProduct(String id){
        return productRepository.getProduct(id);
    }

    public Product updateProduct(Product product) throws Exception{
        return productRepository.updateProduct(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }
}
