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
        AdviceWith.adviceWith(context, "routeId", a -> {
            a.weaveByToString(".*log:output.*").replace().to("mock:output");
        });

        getMockEndpoint("mock:output").expectedMessageCount(1);
        template.sendBody("direct:start", "Test Message");
        assertMockEndpointsSatisfied();
    }
}
