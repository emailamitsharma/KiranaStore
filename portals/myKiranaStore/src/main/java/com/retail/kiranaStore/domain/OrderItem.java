package com.retail.kiranaStore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem extends AbstractTrackedEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7905629565277362798L;

	@Column(name="item_id")
	private Long itemId;
	
	@Column(name="item_quantity")
	private Long itemQuantity;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
