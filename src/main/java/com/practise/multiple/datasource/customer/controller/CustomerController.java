package com.practise.multiple.datasource.customer.controller;

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
import com.practise.multiple.datasource.customer.data.CustomerModel;
import com.practise.multiple.datasource.customer.service.CustomerService;
import com.practise.multiple.datasource.util.Mapper;

@RestController
public class CustomerController {

	Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@PostMapping("/multidatasource/addCustomer")
	public CustomerModel addCustomer(@RequestBody CustomerModel customer) {
		logger.info("CustomerController:addCustomer persist add customer request {}", Mapper.mapToJsonString(customer));
		CustomerModel addCustomer = this.customerService.addCustomer(customer);
		logger.info("CustomerController:addCustomer response from service {}", Mapper.mapToJsonString(addCustomer));
		return addCustomer;
	}

	@GetMapping("/multidatasource/getAllCustomers")
	public Iterable<CustomerModel> getAllCustomers() {
		Iterable<CustomerModel> customerList = this.customerService.findAllCustomers();
		logger.info("CustomerController:getAllCustomers response from service {}", Mapper.mapToJsonString(customerList));
		return customerList;
	}

	@GetMapping("/multidatasource/getCustomer/{custId}")
	public Optional<CustomerModel> getCustomer(@PathVariable int custId) throws NotFoundException {
		logger.info("CustomerController:getCustomer fetch customer by id {}", custId);
		Optional<CustomerModel> customerList = this.customerService.findCustomerById(custId);
		logger.info("CustomerController:getCustomer response from service {}", Mapper.mapToJsonString(customerList));
		return customerList;
	}
}