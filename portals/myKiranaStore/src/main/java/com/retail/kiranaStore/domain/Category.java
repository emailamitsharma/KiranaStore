package com.retail.kiranaStore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "category")
@Where(clause = "deleted = 0")
public class Category extends AbstractTrackedEntity {

	private static final long serialVersionUID = 3759595365355477790L;

	@Column(name = "code", nullable = false, updatable = false, unique = true)
	private String code;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "description")
	private String description;

	@Column(name = "image_url")
	private String imageUrl;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
