package com.practise.multiple.datasource.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practise.multiple.datasource.product.data.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
}