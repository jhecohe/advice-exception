package com.jhecohe.advice_exceptions.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Product {
    
    String id;
    @NotBlank(message = "Name is mandatory")
    String name;
    @Min(value = 0, message = "Stock must be greater than or equal to 0")
    Integer stock;
    @NotNull(message = "Price is mandatory")
    Double price; 
    LocalDate created;

    
    public Product(String id, String name, Integer stock, Double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product() {
    }

    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }




    public String getId() {
        return id;
    }




    public void setId(String id) {
        this.id = id;
    }




    public String getName() {
        return name;
    }




    public void setName(String name) {
        this.name = name;
    }




    public Integer getStock() {
        return stock;
    }




    public void setStock(Integer stock) {
        this.stock = stock;
    }




    public Double getPrice() {
        return price;
    }




    public void setPrice(Double price) {
        this.price = price;
    }




    public LocalDate getCreated() {
        return created;
    }




    public void setCreated(LocalDate created) {
        this.created = created;
    }

    
}
