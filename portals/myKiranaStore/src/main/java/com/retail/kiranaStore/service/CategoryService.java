package com.retail.kiranaStore.service;

import java.util.List;

import com.retail.kiranaStore.domain.Category;

public interface CategoryService {

	public Category createOrUpdateCategory(Category Category);
	
	public List<Category> getAllCategories();	
}
