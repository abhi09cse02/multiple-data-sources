package com.practise.multiple.datasource.customer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.practise.multiple.datasource.customer.data.CustomerModel;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Integer> {
}