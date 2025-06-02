package com.jhecohe.advice_exceptions.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhecohe.advice_exceptions.model.Product;
import com.jhecohe.advice_exceptions.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/v1/products")
public class ProductController {
    
    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()    
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) throws Exception {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping()   
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")   
    public ResponseEntity<Product> getProduct(@PathVariable String id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws Exception{
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted ");
    }
}
