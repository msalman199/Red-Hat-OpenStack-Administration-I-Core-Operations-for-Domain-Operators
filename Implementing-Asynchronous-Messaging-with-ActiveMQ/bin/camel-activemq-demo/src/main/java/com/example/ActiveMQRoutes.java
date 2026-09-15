from("activemq:queue:inputQueue?transacted=true")
    .transacted()
    .log("Received message: ${body}")
    .process(exchange -> {
        String message = exchange.getIn().getBody(String.class);
        if(message.contains("error")) {
            throw new RuntimeException("Simulated error");
        }
        String processedMsg = "Processed: " + message;
        exchange.getMessage().setBody(processedMsg);
    })
    .to("activemq:queue:outputQueue")
    .log("Message processed successfully");
