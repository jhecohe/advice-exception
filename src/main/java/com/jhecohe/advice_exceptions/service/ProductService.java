package com.jhecohe.advice_exceptions.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jhecohe.advice_exceptions.exception.ProductException;
import com.jhecohe.advice_exceptions.model.Product;
import com.jhecohe.advice_exceptions.repository.ProductRepository;

@Service
public class ProductService {

    ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        product.setCreated(LocalDate.now());
        try {
            return productRepository.addProduct(product);
        } catch (Exception e) {
            throw new ProductException("P-500", "Error adding product: " + e.getMessage());
            
        }
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Product getProduct(String id){
        return productRepository.getProduct(id);
    }

    public Product updateProduct(Product product) {
        try {
            return productRepository.updateProduct(product);
        } catch (Exception e) {
            throw new ProductException("P-500", "Error updating product: " + e.getMessage());
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }
}
