import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class AggregatorPatternDemo {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                    .aggregate(header("orderId"), new GroupedExchangeAggregationStrategy())
                    .completionSize(3)
                    .to("stream:out?promptMessage=Completed order batch: ");
            }
        });
        main.run();
    }
}
