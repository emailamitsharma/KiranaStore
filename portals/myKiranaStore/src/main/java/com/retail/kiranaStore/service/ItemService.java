package com.retail.kiranaStore.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.retail.kiranaStore.domain.Item;
import com.retail.kiranaStore.domain.ItemDetails;


public interface ItemService {
	
	ItemDetails create(ItemDetails itemDetail);
	
	ItemDetails update(ItemDetails itemDetail);
	
	List<Item> findAllByCategory(String category ,Pageable pageable);
	
	ItemDetails getItemDetailByItemCode(String ItemCode);
	
}
