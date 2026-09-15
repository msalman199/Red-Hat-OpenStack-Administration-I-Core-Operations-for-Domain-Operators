import org.apache.camel.main.Main;
import org.apache.camel.component.activemq.ActiveMQComponent;

public class ActiveMQDemo {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        
        // Configure ActiveMQ component
        ActiveMQComponent activemq = new ActiveMQComponent();
        activemq.setBrokerURL("tcp://localhost:61616");
        activemq.setUsername("admin");
        activemq.setPassword("admin");
        
        main.bind("activemq", activemq);
        main.addRouteBuilder(new ActiveMQRoutes());
        
        System.out.println("Starting Camel. Press CTRL+C to terminate.");
        main.run();
    }
}
