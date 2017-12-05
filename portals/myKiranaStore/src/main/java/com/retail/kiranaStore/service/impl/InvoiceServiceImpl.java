package com.retail.kiranaStore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.kiranaStore.domain.Invoice;
import com.retail.kiranaStore.repositories.InvoiceRepository;
import com.retail.kiranaStore.service.InvoiceService;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	

	@Override
	public List<Invoice> getAllInvoices() {
		return this.invoiceRepository.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public Invoice createOrUpdateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return this.invoiceRepository.save(invoice);
	}

	@Override
	public Invoice getInvoice(Long invoiceId) {
		// TODO Auto-generated method stub
		return invoiceRepository.findOne(invoiceId);
	}
}
