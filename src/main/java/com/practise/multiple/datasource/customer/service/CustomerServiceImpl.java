package com.practise.multiple.datasource.customer.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import com.practise.multiple.datasource.customer.data.CustomerModel;
import com.practise.multiple.datasource.customer.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerModel addCustomer(CustomerModel customer) {
		CustomerModel addCustomer = this.customerRepository.save(customer);
		return addCustomer;
	}

	@Override
	public Optional<CustomerModel> findCustomerById(int custId) throws NotFoundException {
		Optional<CustomerModel> customerList = this.customerRepository.findById(custId);
		return customerList;
	}

	@Override
	public Iterable<CustomerModel> findAllCustomers() {
		Iterable<CustomerModel> customerList = this.customerRepository.findAll();
		return customerList;
	}
}