package com.dreamforce17.herokucamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.telegram.model.IncomingMessage;

public class TelegrammProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String textIn = ((IncomingMessage)exchange.getIn().getBody()).getText();
		String textOut = textIn + "Reply!";
		
		exchange.getOut().setBody(textOut);
		exchange.getOut().setHeader("CamelTelegramChatId", exchange.getIn().getHeader("CamelTelegramChatId"));
	}

}
