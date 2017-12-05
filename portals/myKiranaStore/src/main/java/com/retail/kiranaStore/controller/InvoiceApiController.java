package com.retail.kiranaStore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.retail.kiranaStore.domain.Invoice;
import com.retail.kiranaStore.service.InvoiceService;

@RestController
@RequestMapping("/api/")
public class InvoiceApiController {

	public static final Logger logger = LoggerFactory.getLogger(InvoiceApiController.class);
	
	@Autowired
	public InvoiceService invoiceService;
	
	// -------------------Create a invoice-------------------------------------------

		@RequestMapping(value = "/invoice", method = RequestMethod.POST)
		public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice, UriComponentsBuilder ucBuilder, ModelMap modal) {
			logger.info("Creating invoice : {}", invoice);
			
			invoiceService.createOrUpdateInvoice(invoice);
			invoice.setTnxId(invoice.getId().toString());
			
			return new ResponseEntity<Invoice>(invoice, HttpStatus.CREATED);
		}

}