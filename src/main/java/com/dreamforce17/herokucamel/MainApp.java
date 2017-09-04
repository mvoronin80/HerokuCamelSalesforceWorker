package com.dreamforce17.herokucamel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {
	public static void main(String args[]) throws Exception {
		CamelContext context = new DefaultCamelContext();
		
		SalesforceComponent salesforce = new SalesforceComponent();
		salesforce.setLoginUrl("https://login.salesforce.com");
		salesforce.setClientSecret("5173328980735565452");
		salesforce.setClientId("3MVG9g9rbsTkKnAWSZgZ2o8IVO7QrN3jOGz8gqLUKHcs40oAjLqcv9EaWJJ0baYCmctLWllvm7PIx_RP3V.zq");
		salesforce.setPassword("Monitor-1234");
		salesforce.setUserName("mv_df17@ds.com");
		salesforce.setPackages("org.apache.camel.salesforce.dto");
		
		context.addComponent("salesforce", salesforce);
		
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("direct:toSalesforce")
					.to("salesforce:limits")
					.process(new SalesforceProcessor());
			}
		});
		context.start();
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		producerTemplate.sendBody("direct:toSalesforce", "Start route");
		Thread.sleep(10000);
		context.stop();
	}
}