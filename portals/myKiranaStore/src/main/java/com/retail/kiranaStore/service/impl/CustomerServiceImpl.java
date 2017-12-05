package com.retail.kiranaStore.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.kiranaStore.domain.Customer;
import com.retail.kiranaStore.repositories.CustomerRepository;



@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findById(Long id) {
		return customerRepository.findOne(id);
	}

	public void saveCustomer(Customer Customer) {
		customerRepository.save(Customer);
	}

	public void updateCustomer(Customer Customer){
		saveCustomer(Customer);
	}

	public void deleteCustomerById(Long id){
		customerRepository.delete(id);
	}

	public void deleteAllCustomers(){
		customerRepository.deleteAll();
	}

	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}

	public boolean isCustomerExist(Customer Customer) {
		return findByName(Customer.getName()) != null;
	}

	@Override
	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
