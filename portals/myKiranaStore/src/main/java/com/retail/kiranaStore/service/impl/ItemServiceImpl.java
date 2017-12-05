package com.retail.kiranaStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.kiranaStore.domain.Item;
import com.retail.kiranaStore.domain.ItemDetails;
import com.retail.kiranaStore.repositories.ItemDetailsRepository;
import com.retail.kiranaStore.repositories.ItemRepository;
import com.retail.kiranaStore.service.ItemService;


@Transactional
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDetailsRepository itemDetailsRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	@Transactional(readOnly=false)
	public ItemDetails create(ItemDetails itemDetail) {
		return this.itemDetailsRepository.save(itemDetail);
	}

	@Override
	@Transactional(readOnly=false)
	public ItemDetails update(ItemDetails itemDetail) {
		return this.itemDetailsRepository.save(itemDetail);
	}

	@Override
	public List<Item> findAllByCategory(String categoryCode, Pageable pageRequest) {
		return this.itemRepository.findAllItemByCategoryCode(categoryCode , pageRequest);
	}

	@Override
	public ItemDetails getItemDetailByItemCode(String ItemCode) {
		return this.itemDetailsRepository.findByItemCode(ItemCode);
	}
}
