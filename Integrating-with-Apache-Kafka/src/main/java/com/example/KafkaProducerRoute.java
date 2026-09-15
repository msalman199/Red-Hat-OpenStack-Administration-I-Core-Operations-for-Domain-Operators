import org.apache.camel.builder.RouteBuilder;

public class KafkaProducerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:foo?period=5000")
            .setBody().simple("Message at ${date:now:yyyy-MM-dd HH:mm:ss}")
            .to("kafka:test-topic?brokers=localhost:9092");
    }
}
.to("kafka:test-topic?brokers=localhost:9092&requestRequiredAcks=all");
from("kafka:test-topic?brokers=localhost:9092"
    + "&autoOffsetReset=earliest"
    + "&allowManualCommit=true")
    .log("Received message: ${body}")
    .to("kafka:test-topic?brokers=localhost:9092"
        + "&groupId=test-group"
        + "&autoCommitEnable=false");
onException(Exception.class)
    .log("Error processing message: ${exception.message}")
    .handled(true);
