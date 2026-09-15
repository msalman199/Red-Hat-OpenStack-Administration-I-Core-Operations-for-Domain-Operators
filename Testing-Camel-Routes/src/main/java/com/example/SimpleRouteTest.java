package com.example;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class SimpleRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SimpleRouteBuilder();
    }

    @Test
    public void testRoute() throws Exception {
        // Mock the endpoint
        AdviceWith.adviceWith(context, "routeId", a -> {
            a.weaveByToUri("mock:result").replace().to("mock:testResult");
        });

        // Send a test message
        template.sendBody("direct:start", "Hello Camel");

        // Assert the result
        getMockEndpoint("mock:testResult").expectedMessageCount(1);
        getMockEndpoint("mock:testResult").expectedBodiesReceived("Hello Camel");
        assertMockEndpointsSatisfied();
    }
}
@Test
public void testErrorHandling() throws Exception {
    // Send a message that triggers an error
    template.sendBody("direct:start", "error");

    // Assert the message was sent to DLQ
    getMockEndpoint("mock:deadLetter").expectedMessageCount(1);
    assertMockEndpointsSatisfied();
}
