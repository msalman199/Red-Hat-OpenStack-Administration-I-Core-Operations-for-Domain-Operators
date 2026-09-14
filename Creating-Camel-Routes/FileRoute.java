package com.example;

import org.apache.camel.builder.RouteBuilder;

public class FileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
            .log("File received: ${file:name}")
            .to("file:data/output");
    }
}
from("jetty:http://localhost:8080/myEndpoint")
    .log("HTTP Request received: ${body}")
    .to("file:data/http-output");
