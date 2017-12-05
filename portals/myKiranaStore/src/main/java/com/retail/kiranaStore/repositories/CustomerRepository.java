package com.retail.kiranaStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.kiranaStore.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
