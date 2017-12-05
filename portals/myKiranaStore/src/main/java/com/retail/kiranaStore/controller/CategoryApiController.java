package com.retail.kiranaStore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.kiranaStore.domain.Category;
import com.retail.kiranaStore.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController {

	public static final Logger logger = LoggerFactory.getLogger(CategoryApiController.class);

	@Autowired
	private CategoryService categoryService; 

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categories = categoryService.getAllCategories();
		if (CollectionUtils.isEmpty(categories)) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

}