package com.bank.mapper;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.bank.domain.Customer;
import com.bank.dto.CustomerDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class CustomerMapperTest {
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Test
	void debeMappearDeCustomeraCustomerDTO() {
		
		//Arrange
		Customer customer = new Customer();
		customer.setAccounts(null);
		customer.setAddress("Rojas Pinilla II 14#12");
		customer.setCustId(130900);
		customer.setEmail("azuluaga@vortexbird.com");
		customer.setEnable(true);
		customer.setName("Andrés Zuluaga");
		customer.setPhone("3197311021");
		customer.setRegisteredAccounts(null);
		customer.setToken(UUID.randomUUID().toString().toUpperCase());
		
		CustomerDTO customerDTO = null;
		
		//Act
		customerDTO = customerMapper.toCustomerDTO(customer);
		
		
		//Assert
		assertNotNull(customerDTO);
	}
	
	@Test
	void debeMappearDeCustomerDTOaCustomer() {
		//Arrange
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setAddress("Guaduales de la villa 3 # 27");
		customerDTO.setCustId(123456);
		customerDTO.setEmail("nidia@gmail.com");
		customerDTO.setEnable(true);
		customerDTO.setName("Nidia Velasquez");
		customerDTO.setPhone("3117333647");
		customerDTO.setToken(UUID.randomUUID().toString().toUpperCase());
		customerDTO.setDotyId(1);
		Customer customer = null;
		
		//Act
		customer = customerMapper.toCustomer(customerDTO);
		
		//Assert
		assertNotNull(customer);
	}
	

}
