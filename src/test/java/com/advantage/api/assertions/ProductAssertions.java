package com.advantage.api.assertions;

import io.restassured.response.Response;
import org.junit.Assert;

public class ProductAssertions {

    private ProductAssertions() {
    }

    public static void validateProductsResponse(
            Response response) {

        Assert.assertEquals(
                200,
                response.statusCode()
        );

        Assert.assertEquals(
                "application/json",
                response.getContentType().split(";")[0]
        );

        Assert.assertNotNull(
                response.body()
        );
    }
}