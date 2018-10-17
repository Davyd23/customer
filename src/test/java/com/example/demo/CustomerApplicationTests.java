package com.example.demo;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CustomerService customerService;

	@Test
	public void modelTests() {
		Customer customer = new Customer("David", "david@test");
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

		assert (customer.getName().equals(customerDto.getName()));
		assert (customer.getEmail().equals(customerDto.getEmail()));

		customer = modelMapper.map(customerDto, Customer.class);

		assert (customer.getName().equals(customerDto.getName()));
		assert (customer.getEmail().equals(customerDto.getEmail()));
	}

	@Test
	@Rollback
	public void serviceTests(){
		CustomerDto customer = new CustomerDto("David", "david@test");

		CustomerDto insertedCustomer = customerService.save(customer);

		assert ( customer.getEmail().equals(insertedCustomer.getEmail()));
		assert ( customer.getName().equals(insertedCustomer.getName()));

		List<CustomerDto> customerList = customerService.findAll();
		assert (customerList.size() == 1);

		customerService.save(customer);
		customerList = customerService.findAll();
		assert (customerList.size() == 1);

		customer.setEmail("a@a");
		customerService.save(customer);
		customerList = customerService.findAll();
		assert (customerList.size() == 2);
	}

}
