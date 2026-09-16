from("file:input?noop=true")
    .log("File content: ${body}")
    .to("file:output");
from("file:input?noop=true")
    .transform(body().append("\nProcessed at: ").append(header("CamelFileName")))
    .to("file:output");
from("timer:dbTimer?period=10000")
    .setBody(constant("INSERT INTO users(name, email) VALUES ('John', 'john@example.com')"))
    .to("jdbc:dataSource");
from("direct:insertMongo")
    .setBody(constant("{name: 'Jane', email: 'jane@example.com'}"))
    .to("mongodb:myDb?database=test&collection=users&operation=insert");
from("file:input?fileName=data.csv&noop=true")
    .unmarshal().csv()
    .marshal().json()
    .to("file:output?fileName=data.json");
from("file:input?noop=true")
    .unmarshal().jacksonXml()
    .marshal().json()
    .to("file:output");
