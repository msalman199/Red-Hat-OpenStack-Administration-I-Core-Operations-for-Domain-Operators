import org.apache.camel.builder.RouteBuilder;

public class RestServiceRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // REST configuration
        restConfiguration()
            .component("jetty")
            .host("localhost")
            .port(8080)
            .bindingMode(RestBindingMode.json);
    }
}
restConfiguration()
    .component("jetty")
    .host("localhost")
    .port(8080)
    .bindingMode(RestBindingMode.json)
    .dataFormatProperty("prettyPrint", "true");
