import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:foo?period=5000")
          .log("Microservice triggered at ${header.firedTime}");
    }
}
rest("/api")
  .get("/hello")
  .produces("text/plain")
  .route()
  .setBody(constant("Hello from Camel Microservice!"))
  .endRest();
