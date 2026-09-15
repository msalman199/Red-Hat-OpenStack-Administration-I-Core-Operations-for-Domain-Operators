import org.apache.camel.builder.RouteBuilder;

public class KafkaConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:test-topic?brokers=localhost:9092")
            .log("Received message: ${body}");
    }
}
