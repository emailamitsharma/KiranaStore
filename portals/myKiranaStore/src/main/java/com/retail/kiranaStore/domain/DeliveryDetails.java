package com.retail.kiranaStore.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.retail.kiranaStore.util.DeliveryOption;

@Entity
@Table(name = "delivery_details")
public class DeliveryDetails extends AbstractTrackedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -755765598710163656L;

	@Column(name = "delivery_option")
	@Enumerated(EnumType.STRING)
	private DeliveryOption deliveryOption;

	@Column(name = "delivery_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;
	
	@Column(name="delivery_cost")
	private Double deliveryCost;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "address_id")
	private Address deliveryAdddress;

	public DeliveryOption getDeliveryOption() {
		return deliveryOption;
	}

	public void setDeliveryOption(DeliveryOption deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Address getDeliveryAdddress() {
		return deliveryAdddress;
	}

	public void setDeliveryAdddress(Address deliveryAdddress) {
		this.deliveryAdddress = deliveryAdddress;
	}

}
