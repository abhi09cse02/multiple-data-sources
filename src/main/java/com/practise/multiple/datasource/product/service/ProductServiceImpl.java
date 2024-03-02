package com.practise.multiple.datasource.product.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.practise.multiple.datasource.product.data.ProductModel;
import com.practise.multiple.datasource.product.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductModel addProduct(ProductModel product) {
		ProductModel addProduct = this.productRepository.save(product);
		return addProduct;
	}

	@Override
	public Optional<ProductModel> findProductById(int prodId) throws NotFoundException {
		Optional<ProductModel> productList = this.productRepository.findById(prodId);
		return productList;
	}

	@Override
	public Iterable<ProductModel> findAllProducts() {
		Iterable<ProductModel> productList = this.productRepository.findAll();
		return productList;
	}
}