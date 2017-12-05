package com.retail.kiranaStore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_details")
public class ItemDetails extends AbstractTrackedEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3006530542363172620L;

	@OneToOne
	private Item item;

	@Column(name = "description")
	private String description;

	@Column(name = "large_image_url")
	private String largeImageURL;

	@Column(name = "key_features")
	private String keyFeatures;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLargeImageURL() {
		return largeImageURL;
	}

	public void setLargeImageURL(String largeImageURL) {
		this.largeImageURL = largeImageURL;
	}

	public String getKeyFeatures() {
		return keyFeatures;
	}

	public void setKeyFeatures(String keyFeatures) {
		this.keyFeatures = keyFeatures;
	}

}
