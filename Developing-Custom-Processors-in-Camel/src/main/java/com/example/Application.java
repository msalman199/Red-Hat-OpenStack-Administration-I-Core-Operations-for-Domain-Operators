package com.example;

import org.apache.camel.main.Main;
import com.example.routes.CustomProcessorRoute;

public class CustomProcessorApp {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new CustomProcessorRoute());
        main.run(args);
    }
}
package com.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DataEnrichmentProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        
        // Enrich with additional data
        String enriched = "ENRICHED: " + body + " | Processed at: " 
            + System.currentTimeMillis();
            
        exchange.getIn().setBody(enriched);
    }
}


package com.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ValidationProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        
        if (body == null || body.trim().isEmpty()) {
            throw new IllegalArgumentException("Message body cannot be empty");
        }
        
        if (body.startsWith("ERROR")) {
            exchange.getIn().setHeader("validationStatus", "FAILED");
        } else {
            exchange.getIn().setHeader("validationStatus", "PASSED");
        }
    }
}


from("direct:start")
    .process(new ValidationProcessor())
    .choice()
        .when(header("validationStatus").isEqualTo("PASSED"))
            .process(new DataEnrichmentProcessor())
            .to("log:successLog")
        .otherwise()
            .to("log:errorLog")
            .stop();


from("timer:testTimer?period=5000")
    .setBody().simple("Test message ${date:now:HH:mm:ss}")
    .to("direct:start");
