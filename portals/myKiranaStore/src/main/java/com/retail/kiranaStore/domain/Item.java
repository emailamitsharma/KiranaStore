package com.retail.kiranaStore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item extends AbstractTrackedEntity {

	private static final long serialVersionUID = 2369330225663149802L;

	@Column(name = "code", unique = true, nullable = false)
	private String code;

	@Column(name = "name")
	private String name;
	
	@Column(name="category_code")
	private String categoryCode;

	@Column(name = "miniImageURL")
	private String miniImageURL;

	@Column(name = "price")
	private Double price;

	@Column(name = "unitTypeCode")
	private String unitTypeCode;

	@Column(name = "discountCode")
	private String discountCode;
	
	@Column(name = "item_unit_count")
	private Long itemUnitCount;
	
	@Column(name = "description")
	private String itemDescription;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiniImageURL() {
		return miniImageURL;
	}

	public void setMiniImageURL(String miniImageURL) {
		this.miniImageURL = miniImageURL;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnitTypeCode() {
		return unitTypeCode;
	}

	public void setUnitTypeCode(String unitTypeCode) {
		this.unitTypeCode = unitTypeCode;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Long getItemUnitCount() {
		return itemUnitCount;
	}

	public void setItemUnitCount(Long itemUnitCount) {
		this.itemUnitCount = itemUnitCount;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
}
