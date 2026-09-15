package com.example;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
            .log("Received message: ${body}")
            .to("mock:result");
    }
}
public class SimpleRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        errorHandler(deadLetterChannel("mock:deadLetter"));

        from("direct:start")
            .choice()
                .when(body().contains("error"))
                    .throwException(new IllegalArgumentException("Invalid message"))
                .otherwise()
                    .log("Valid message: ${body}")
                    .to("mock:result");
    }
}
