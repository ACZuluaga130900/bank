package com.bank.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;

import com.bank.domain.Customer;
import com.bank.domain.DocumentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Rollback(false)
class CustomerServiceTest {

	@Autowired
	CustomerService customerService;

	@Autowired
	DocumentTypeService documentTypeService;

	@Test
	@Order(1)
	void debeCrearUnCustomer() throws Exception {
		// Arrange
		DocumentType documentType = null;
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

		Optional<DocumentType> documentTypeOptional = documentTypeService.findById(1);

		if (documentTypeOptional.isPresent()) {
			documentType = documentTypeOptional.get();
		}

		customer.setDocumentType(documentType);
		// Act
		customerService.save(customer);

		// Assert
		assertNotNull(customer);

	}

//	@Test
	@Order(2)
	void debeConsultarUnCustomer() {
		// Arrange
		Optional<Customer> customerOptional = null;

		// Act
		customerOptional = customerService.findById(130900);

		// Assert
		assertTrue(customerOptional.isPresent());

	}

	@Test
	@Order(3)
	void debeModificarUnCustomer() throws Exception {
		Optional<Customer> customerOptional = null;
		Customer customer = null;
		customerOptional = customerService.findById(130900);
		assertTrue(customerOptional.isPresent());
		customer = customerOptional.get();
		customer.setEnable(false);

		// Act
		customerService.update(customer);

		// Assert
		assertFalse(customer.getEnable());
	}

	@Test
	@Order(4)
	void debeBorrarUnCustomer() throws Exception {
		// Arrange
		Optional<Customer> customerOptional = null;
		Customer customer = null;
		customerOptional = customerService.findById(130900);
		assertTrue(customerOptional.isPresent());
		customer = customerOptional.get();

		// Act
		customerService.delete(customer);

	}

}
