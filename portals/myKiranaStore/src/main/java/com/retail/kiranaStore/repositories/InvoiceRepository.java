package com.retail.kiranaStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.kiranaStore.domain.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
