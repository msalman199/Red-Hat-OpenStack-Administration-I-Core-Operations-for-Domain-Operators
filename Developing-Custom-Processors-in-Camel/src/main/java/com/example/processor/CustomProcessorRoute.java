package com.example.routes;

import org.apache.camel.builder.RouteBuilder;
import com.example.processor.SimpleLoggingProcessor;

public class CustomProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:simpleTimer?period=1000")
            .setBody().simple("Current time is ${date:now:HH:mm:ss}")
            .process(new SimpleLoggingProcessor())
            .to("log:processedOutput");
    }
}
