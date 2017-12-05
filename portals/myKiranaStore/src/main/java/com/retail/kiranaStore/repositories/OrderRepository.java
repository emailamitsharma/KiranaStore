package com.retail.kiranaStore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.kiranaStore.domain.Customer;
import com.retail.kiranaStore.domain.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findByCustomer(Customer customer);

}
