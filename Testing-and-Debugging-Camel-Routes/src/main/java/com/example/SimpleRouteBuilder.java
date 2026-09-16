package com.example;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:myTimer?period=1000")
            .log("Processing message: ${body}")
            .to("log:output");
    }
}
public void configure() throws Exception {
    getContext().setTracing(true);
    from("timer:myTimer?period=1000")
        .log("Processing message: ${body}")
        .to("log:output");
}
from("timer:myTimer?period=1000")
    .log("Processing message: ${body}")
    .process(exchange -> { throw new RuntimeException("Simulated error"); })
    .to("log:output");;
