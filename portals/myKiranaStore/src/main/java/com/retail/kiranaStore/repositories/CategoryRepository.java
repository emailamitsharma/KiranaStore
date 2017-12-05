package com.retail.kiranaStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.kiranaStore.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
