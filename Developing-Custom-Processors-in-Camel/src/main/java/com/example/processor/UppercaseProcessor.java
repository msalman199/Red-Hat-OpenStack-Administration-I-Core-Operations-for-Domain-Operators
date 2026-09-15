package com.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SimpleLoggingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        // Processor logic will go here
    }
}
@Override
public void process(Exchange exchange) throws Exception {
    String body = exchange.getIn().getBody(String.class);
    System.out.println("Processing message with body: " + body);
    
    // Add a custom header
    exchange.getIn().setHeader("processedBy", "SimpleLoggingProcessor");
    
    // Modify the body
    if (body != null) {
        exchange.getIn().setBody(body.toUpperCase());
    }
}
