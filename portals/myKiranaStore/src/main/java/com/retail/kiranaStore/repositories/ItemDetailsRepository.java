package com.retail.kiranaStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.kiranaStore.domain.ItemDetails;


public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Long>{
	
	@Query("select itemDetail from ItemDetails itemDetail where itemDetail.item.code=:itemCode")
	ItemDetails findByItemCode(@Param("itemCode")String itemCode);

}
