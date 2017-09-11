package com.dreamforce17.herokucamel;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.Processor;
import org.apache.camel.salesforce.dto.Contact;
import org.apache.camel.salesforce.dto.QueryRecordsContact;
import org.apache.camel.salesforce.dto.Case;

public class SalesforceProcessor /*implements Processor*/ {

	/*
	@Override
	public void process(Exchange exchange) throws Exception {
		Contact contact = exchange.getIn().getBody(QueryRecordsContact.class).getRecords().get(0);
		Case newCase = new Case();
		newCase.setContactId(contact.getId());
		newCase.setSubject((String)exchange.getIn().getHeader("TelegramRequest"));
		exchange.getIn().setBody(newCase);
	}
	*/
	
	public Case process(@Body QueryRecordsContact contacts, @Header("TelegramRequest") String request) {
		Case newCase = new Case();
		newCase.setContactId(contacts.getRecords().get(0).getId());
		newCase.setSubject(request);
		return newCase;
	}
}
