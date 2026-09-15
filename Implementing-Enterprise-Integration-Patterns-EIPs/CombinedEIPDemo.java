import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class CombinedEIPDemo {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // Split incoming CSV into rows
                from("direct:start")
                    .split(body().tokenize("\n"))
                    .to("direct:processRow");
                
                // Route rows based on content
                from("direct:processRow")
                    .choice()
                        .when(body().contains("ERROR"))
                            .to("direct:errorHandler")
                        .when(body().contains("WARN"))
                            .to("direct:warnHandler")
                        .otherwise()
                            .to("direct:infoHandler");
                
                // Aggregate errors
                from("direct:errorHandler")
                    .aggregate(constant(true), new GroupedExchangeAggregationStrategy())
                    .completionSize(5)
                    .to("stream:out?promptMessage=Error batch: ");
            }
        });
        main.run();
    }
}
String csvData = "INFO,Service started\n" +
                 "WARN,Low disk space\n" +
                 "ERROR,Database connection failed\n" +
                 "INFO,User logged in\n" +
                 "ERROR,File not found\n" +
                 "WARN,High memory usage\n" +
                 "ERROR,Timeout occurred\n" +
                 "ERROR,Authentication failed\n" +
                 "ERROR,Null pointer exception";

template.sendBody("direct:start", csvData);
