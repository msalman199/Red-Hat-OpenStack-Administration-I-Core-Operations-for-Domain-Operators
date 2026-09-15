import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class ContentBasedRouterDemo {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                    .choice()
                        .when(header("priority").isEqualTo("high"))
                            .to("stream:out?promptMessage=High priority message: ")
                        .when(header("priority").isEqualTo("medium"))
                            .to("stream:out?promptMessage=Medium priority message: ")
                        .otherwise()
                            .to("stream:out?promptMessage=Low priority message: ");
            }
        });
        main.run();
    }
}

// In a separate test class or main method
ProducerTemplate template = main.getCamelContext().createProducerTemplate();
template.sendBodyAndHeader("direct:start", "Urgent server issue", "priority", "high");
template.sendBodyAndHeader("direct:start", "Regular update", "priority", "medium");
template.sendBodyAndHeader("direct:start", "Informational message", "priority", "low");

