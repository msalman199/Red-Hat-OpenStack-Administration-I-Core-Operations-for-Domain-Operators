import org.apache.camel.builder.RouteBuilder;

public class EventDrivenRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:eventTimer?period=5000")
            .setBody().simple("Event generated at ${date:now:yyyy-MM-dd HH:mm:ss}")
            .log("Event: ${body}");
    }
}
from("activemq:queue:testQueue")
    .log("Received from ActiveMQ: ${body}");
from("timer:activeMqTimer?period=10000")
    .setBody().simple("Test message at ${date:now:HH:mm:ss}")
    .to("activemq:queue:testQueue");
// Producer
from("timer:kafkaTimer?period=8000")
    .setBody().simple("Kafka message at ${date:now:HH:mm:ss}")
    .to("kafka:testTopic?brokers=localhost:9092");

// Consumer
from("kafka:testTopic?brokers=localhost:9092")
    .log("Received from Kafka: ${body}");
