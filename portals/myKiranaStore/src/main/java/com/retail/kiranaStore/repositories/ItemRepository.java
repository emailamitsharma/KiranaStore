package com.retail.kiranaStore.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.kiranaStore.domain.Item;


public interface ItemRepository extends JpaRepository<Item, Long>{

	List<Item> findAllItemByCategoryCode(String categoryCode, Pageable pageRequest);

}
