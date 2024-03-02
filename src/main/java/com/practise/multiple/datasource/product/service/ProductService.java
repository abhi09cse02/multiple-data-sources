package com.practise.multiple.datasource.product.service;

import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.practise.multiple.datasource.product.data.ProductModel;

public interface ProductService {
    
	Iterable<ProductModel> findAllProducts();

	ProductModel addProduct(ProductModel product);
    
    Optional<ProductModel> findProductById(int prodId) throws NotFoundException;
}