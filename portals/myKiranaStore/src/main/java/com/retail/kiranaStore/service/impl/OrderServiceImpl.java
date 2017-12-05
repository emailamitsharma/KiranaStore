package com.retail.kiranaStore.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.kiranaStore.domain.Customer;
import com.retail.kiranaStore.domain.Item;
import com.retail.kiranaStore.domain.Order;
import com.retail.kiranaStore.repositories.OrderRepository;
import com.retail.kiranaStore.service.OrderService;


@Transactional
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order create(Order order) {
		return this.orderRepository.save(order);
	}

	@Override
	public Order addItemToOrder(Order order, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order removeItemFromOrder(Order order, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(Order order) {
		return this.orderRepository.save(order);
	}

	@Override
	public List<Order> listAllOrderByCustomer(Customer customer) {
		return this.orderRepository.findByCustomer(customer);
	}

	@Override
	public List<Order> listAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
