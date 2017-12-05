package com.retail.kiranaStore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "invoice")
public class Invoice extends AbstractTrackedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3999698601884923871L;

	@ManyToOne
	@JoinColumn(columnDefinition="delivery_detail_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(columnDefinition="oracle_id")
	private Order order;
	
	@OneToOne
	@JoinColumn(columnDefinition="delivery_detail_id")
	private DeliveryDetails deliveryDetails;
	
	@Column(name="total_actaul_price")
	private Double totalActaulPrice;
	
	@Column(name="transaction_id")
	private String tnxId;
	
	@Column(name="total_discount")
	private Double totalDiscount;
	
	@Column(name="net_payble_price")
	private Double netPayblePrice;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public DeliveryDetails getDeliveryDetails() {
		return deliveryDetails;
	}

	public void setDeliveryDetails(DeliveryDetails deliveryDetails) {
		this.deliveryDetails = deliveryDetails;
	}

	public Double getTotalActaulPrice() {
		return totalActaulPrice;
	}

	public void setTotalActaulPrice(Double totalActaulPrice) {
		this.totalActaulPrice = totalActaulPrice;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Double getNetPayblePrice() {
		return netPayblePrice;
	}

	public void setNetPayblePrice(Double netPayblePrice) {
		this.netPayblePrice = netPayblePrice;
	}

	public String getTnxId() {
		return tnxId;
	}

	public void setTnxId(String tnxId) {
		this.tnxId = tnxId;
	}
}
