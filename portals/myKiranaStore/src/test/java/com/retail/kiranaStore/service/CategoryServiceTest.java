package com.retail.kiranaStore.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.kiranaStore.domain.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@SpringBootConfiguration
public class CategoryServiceTest extends AbstractTestData {
	
	
	@Test
	public void createOrUpdateCategory(){
		super.categoryService.createOrUpdateCategory(super.getCategory());
	}
	
	@Test
	public void getAllCategories() {
		List<Category> categories = super.categoryService.getAllCategories();
	}

}
