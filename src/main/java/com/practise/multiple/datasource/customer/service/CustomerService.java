package com.practise.multiple.datasource.customer.service;

import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.practise.multiple.datasource.customer.data.CustomerModel;

public interface CustomerService {
    
	Iterable<CustomerModel> findAllCustomers();

    CustomerModel addCustomer(CustomerModel customer);
    
    Optional<CustomerModel> findCustomerById(int custId) throws NotFoundException;
}