rest("/api")
    .post("/products")
        .description("Create new product")
        .type(Product.class)
        .outType(Product.class)
        .to("direct:createProduct");

from("direct:createProduct")
    .process(exchange -> {
        Product product = exchange.getIn().getBody(Product.class);
        // In real app, save to database
        product.setId("generated-" + System.currentTimeMillis());
        exchange.getMessage().setBody(product);
    });
