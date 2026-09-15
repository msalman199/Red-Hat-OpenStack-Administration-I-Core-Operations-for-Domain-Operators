import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TransactionRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
            .transacted()  // Enable transaction support
            .log("Inserting data into database...")
            .to("sql:INSERT INTO orders (id, product, amount) VALUES (1, 'Laptop', 1000)")
            .log("Data inserted successfully.");
    }
}
