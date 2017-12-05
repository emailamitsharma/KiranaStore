package com.retail.kiranaStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.kiranaStore.domain.Category;
import com.retail.kiranaStore.repositories.CategoryRepository;
import com.retail.kiranaStore.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional(readOnly=false)
	public Category createOrUpdateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll();
	}

}
