package com.retail.kiranaStore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.retail.kiranaStore.domain.Category;
import com.retail.kiranaStore.domain.ItemDetails;

public abstract class AbstractTestData {

	@Autowired
	protected ItemService itemService;
	
	@Autowired
	protected CategoryService categoryService;
	
	protected ItemDetails getItemDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
