from("activemq:queue:testQueue")
    .log("JMS Message: ${body}")
    .to("file:data/jms-output");
