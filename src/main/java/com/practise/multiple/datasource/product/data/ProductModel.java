package com.practise.multiple.datasource.product.data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotEmpty(message = "code can not be empty")
    @NotBlank(message = "code can not be blank")
    @NotNull(message = "code can not be null")
    @Size(min = 5, max = 50, message = "code must be between 5 and 50 characters long")
    private String code;
    
    @Column(nullable = false)
    @NotEmpty(message = "name can not be empty")
    @NotBlank(message = "name can not be blank")
    @NotNull(message = "name can not be null")
    @Size(min = 10, max = 100, message = "name must be between 10 and 100 characters long")
    private String name;
    private double price;


    protected ProductModel() {}

    public ProductModel(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Product[id=%d, code='%s', name='%s', price='%s']",
                id, code, name,price);
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}