package com.retail.kiranaStore.service;

import java.util.List;

import com.retail.kiranaStore.domain.Customer;
import com.retail.kiranaStore.domain.Item;
import com.retail.kiranaStore.domain.Order;


public interface OrderService {

	public Order create(Order order);
	
	public Order addItemToOrder(Order order , Item item);
	
	public Order removeItemFromOrder(Order order , Item item);
	
	public Order updateOrder(Order order);
	
	public List<Order> listAllOrderByCustomer(Customer customer);
	
	public List<Order> listAllOrders();
	
}
