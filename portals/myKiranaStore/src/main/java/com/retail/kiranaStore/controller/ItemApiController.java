package com.retail.kiranaStore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.kiranaStore.domain.Item;
import com.retail.kiranaStore.domain.ItemDetails;
import com.retail.kiranaStore.service.ItemService;
import com.retail.kiranaStore.util.CustomErrorType;

@RestController
@RequestMapping("/api/item")
public class ItemApiController {

	public static final Logger logger = LoggerFactory.getLogger(ItemApiController.class);

	@Autowired
	private ItemService itemService; 

	@RequestMapping(value = "/list/{catCode}", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listAllItems(@PathVariable("catCode")String categoryCode) {
		int currentPageNumber = 0;
		int pageSize = 10;
		
		List<Item> items = itemService.findAllByCategory(categoryCode, new PageRequest(currentPageNumber, pageSize));
		if (CollectionUtils.isEmpty(items)) {
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	// -------------------Retrieve Single item------------------------------------------

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<ItemDetails> getItem(@PathVariable("code") String itemCode) {
		logger.info("Fetching Item Detail for item code {}", itemCode);
		ItemDetails itemDetail = itemService.getItemDetailByItemCode(itemCode);
		if (itemDetail == null) {
			logger.error("Item Detail for item code {} not found.", itemCode);
			return new ResponseEntity(new CustomErrorType("item with idItem Detail for item code " + itemCode 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ItemDetails>(itemDetail, HttpStatus.OK);
	}

}