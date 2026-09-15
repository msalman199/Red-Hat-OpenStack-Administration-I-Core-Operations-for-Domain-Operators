import org.apache.camel.builder.RouteBuilder;

public class KafkaProducerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:foo?period=5000")
            .setBody().simple("Message at ${date:now:yyyy-MM-dd HH:mm:ss}")
            .to("kafka:test-topic?brokers=localhost:9092");
    }
}
import org.apache.camel.main.Main;

public class KafkaApp {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new KafkaProducerRoute());
        main.run();
    }
}
main.configure().addRoutesBuilder(new KafkaProducerRoute());
main.configure().addRoutesBuilder(new KafkaConsumerRoute());
