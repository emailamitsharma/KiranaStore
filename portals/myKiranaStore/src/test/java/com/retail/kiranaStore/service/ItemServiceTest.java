package com.retail.kiranaStore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.kiranaStore.configuration.JpaConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(JpaConfiguration.class)
public class ItemServiceTest extends AbstractTestData {
	
	@Test
	public void createTest() {
		super.itemService.create(super.getItemDetail());
	}
	
	@Test
	public void  updateTest(){
//		ItemDetails itemDetail
//		this.itemService.update(super.getItemDetail());
	}
	
	@Test
	public void  findAllByCategoryTest(){
		//String category ,Pageable pageable
	}
	
	@Test
	public void  getItemDetailByItemCode(){
		//String ItemCode
	}
}
