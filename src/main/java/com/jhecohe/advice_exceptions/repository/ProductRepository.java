package com.jhecohe.advice_exceptions.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.jhecohe.advice_exceptions.exception.ProductException;
import com.jhecohe.advice_exceptions.model.Product;


@Repository
public class ProductRepository {
    
    public static Set<Product> productList;

    ProductRepository(){
        productList = new HashSet<>();
    }

    public Product addProduct(Product product) throws Exception {
        if(!productList.add(product)) {
            throw new Exception(" This product is alredy in the DB");
        }
        return getProduct(product.getId());
    }

    public List<Product> getAll(){
        return new ArrayList<Product>(productList);
    }

    public Product getProduct(String id){
        Optional<Product> p = productList.stream().filter(pil -> pil.getId().equals(id)).findFirst();

        return p.orElseThrow(ProductException::new);
    }

    public Product updateProduct(Product product) throws Exception{

        Product update = getProduct(product.getId());
        update.setName(product.getName());
        update.setPrice(product.getPrice());

        return addProduct(product);
    }

    public void deleteProduct(String id) {
        productList.remove(getProduct(id));
    }
}
