from("timer:foo?period=5000")
  .routeId("monitored-route")
  .log("Route executed at ${header.firedTime}")
  .to("log:route.output");
from("timer:foo?period=5000")
  .routeId("monitored-route")
  .doTry()
    .process(exchange -> {
      // Simulate occasional failure
      if (System.currentTimeMillis() % 3 == 0) {
        throw new RuntimeException("Simulated error");
      }
    })
  .doCatch(Exception.class)
    .to("micrometer:counter:route.errors")
    .log("Error occurred: ${exception.message}")
  .end();
