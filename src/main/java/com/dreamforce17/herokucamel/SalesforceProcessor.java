package com.dreamforce17.herokucamel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class SalesforceProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message msg = exchange.getIn();
		Object sf = msg.getBody();
		System.out.println(sf);
	}
}
