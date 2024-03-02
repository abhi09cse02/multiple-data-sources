package com.practise.multiple.datasource.product.controller;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.practise.multiple.datasource.product.data.ProductModel;
import com.practise.multiple.datasource.product.service.ProductService;
import com.practise.multiple.datasource.util.Mapper;

@RestController
public class ProductController {

	Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/multidatasource/addProduct")
	public ProductModel addProduct(@RequestBody ProductModel product) {
		logger.info("ProductController:addCustomer persist add product request {}", Mapper.mapToJsonString(product));
		ProductModel addProduct = this.productService.addProduct(product);
		logger.info("ProductController:addCustomer response from service {}", Mapper.mapToJsonString(product));
		return addProduct;
	}

	@GetMapping("/multidatasource/getAllProducts")
	public Iterable<ProductModel> getAllProducts() {
		Iterable<ProductModel> productList = this.productService.findAllProducts();
		logger.info("ProductController:getAllCustomers response from service {}", Mapper.mapToJsonString(productList));
		return productList;
	}

	@GetMapping("/multidatasource/getProduct/{prodId}")
	public Optional<ProductModel> getProduct(@PathVariable int prodId) throws NotFoundException {
		logger.info("ProductController:getCustomer fetch product by id {}", prodId);
		Optional<ProductModel> productList = this.productService.findProductById(prodId);
		logger.info("ProductController:getCustomer response from service {}", Mapper.mapToJsonString(productList));
		return productList;
	}
}