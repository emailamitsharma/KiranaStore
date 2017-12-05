package com.retail.kiranaStore.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer extends AbstractTrackedEntity {

	private static final long serialVersionUID = -7587138210880595622L;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	@Column(name = "offer_type")
	private String offerType;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name="offer_discount")
	private Integer offerDiscount;

	@Column(name = "is_active")
	private boolean isActive;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getOfferDiscount() {
		return offerDiscount;
	}

	public void setOfferDiscount(Integer offerDiscount) {
		this.offerDiscount = offerDiscount;
	}
}
