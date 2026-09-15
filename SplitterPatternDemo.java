import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class SplitterPatternDemo {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                    .split(body().tokenize(","))
                    .to("stream:out?promptMessage=Processing item: ");
            }
        });
        main.run();
    }
}
