import org.apache.camel.builder.RouteBuilder;  

public class SimpleRouteBuilder extends RouteBuilder {  
    @Override  
    public void configure() throws Exception {  
        from("timer:myTimer?period=1000")  
            .log("Hello from Apache Camel!");  
    }  
}  
