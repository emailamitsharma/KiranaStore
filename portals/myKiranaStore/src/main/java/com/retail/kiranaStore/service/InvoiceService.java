package com.retail.kiranaStore.service;

import java.util.List;

import com.retail.kiranaStore.domain.Category;
import com.retail.kiranaStore.domain.Invoice;

public interface InvoiceService {

	public Invoice createOrUpdateInvoice(Invoice invoice);
	
	public List<Invoice> getAllInvoices();	
	
	public Invoice getInvoice(Long invoiceId);
}
