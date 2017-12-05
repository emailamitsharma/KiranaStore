package com.retail.kiranaStore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.retail.kiranaStore.domain.Customer;
import com.retail.kiranaStore.service.impl.CustomerService;
import com.retail.kiranaStore.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class CustomerApiController {

	public static final Logger logger = LoggerFactory.getLogger(CustomerApiController.class);

	@Autowired
	CustomerService CustomerService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Customers---------------------------------------------

	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> listAllCustomers() {
		List<Customer> Customers = CustomerService.findAllCustomers();
		if (Customers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Customer>>(Customers, HttpStatus.OK);
	}

	// -------------------Retrieve Single Customer------------------------------------------

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable("id") long id) {
		logger.info("Fetching Customer with id {}", id);
		Customer Customer = CustomerService.findById(id);
		if (Customer == null) {
			logger.error("Customer with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Customer with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
	}

	// -------------------Create a Customer-------------------------------------------

	@RequestMapping(value = "/customer/", method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody Customer Customer, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Customer : {}", Customer);

		if (CustomerService.isCustomerExist(Customer)) {
			logger.error("Unable to create. A Customer with name {} already exist", Customer.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Customer with name " + 
					 Customer.getName()+ " already exist."),HttpStatus.CONFLICT);
		}
		CustomerService.saveCustomer(Customer);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/Customer/{id}").buildAndExpand(Customer.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}


}