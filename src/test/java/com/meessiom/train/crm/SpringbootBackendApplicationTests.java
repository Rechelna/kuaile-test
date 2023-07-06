package com.meessiom.train.crm;

import com.meessiom.train.crm.customer.model.Customer;
import com.meessiom.train.crm.customer.repository.CustomerRepository;
import com.meessiom.train.crm.utils.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBackendApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void generateCustomer(){
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setCustomerName(Mock.randomName());
			customer.setCustomerAddress(Mock.randomAddress());
			customer.setCustomerPhone(Mock.randomPhone());
			customerRepository.save(customer);
		}
	}

}


