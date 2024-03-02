package com.practise.multiple.datasource.main;

import com.practise.multiple.datasource.customer.data.CustomerModel;
import com.practise.multiple.datasource.customer.repo.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourcesCustomerTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	@Transactional("customerTransactionManager")
	public void create_check_customer() {

		CustomerModel customer = new CustomerModel("user@javadevjournal.com", "Robert", "Hickle");
		customer = customerRepository.save(customer);

		assertNotNull(customerRepository.findById(customer.getId()));
		assertEquals(customerRepository.findById(customer.getId()).get().getEmail(), "user@javadevjournal.com");
	}
}