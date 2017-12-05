/**
 * 
 */
package com.retail.kiranaStore.service.impl;

import java.util.List;

import com.retail.kiranaStore.domain.Customer;

/**
 * @author Amit.Sharma1
 *
 */
public interface CustomerService {

	

	Customer findById(Long id);

	Customer findByName(String name);

	void saveCustomer(Customer Customer);

	void updateCustomer(Customer Customer);

	void deleteCustomerById(Long id);

	void deleteAllCustomers();

	List<Customer> findAllCustomers();

	boolean isCustomerExist(Customer Customer);
}
