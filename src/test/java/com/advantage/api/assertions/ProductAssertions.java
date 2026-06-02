package com.advantage.api.assertions;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

public class ProductAssertions {

    private ProductAssertions() {}

    public static void validateSuccessResponse(Response response) {

        Assert.assertEquals(200, response.statusCode());

        Assert.assertEquals(
                "application/json",
                response.contentType().split(";")[0]
        );

        Assert.assertTrue(
                response.jsonPath().getList("products").size() > 0
        );
    }

    public static void validateProductsSchema(Response response) {

        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(
                        "schemas/products-schema.json"
                ));
    }
}