package com.advantage.api.assertions;

import io.restassured.response.Response;
import org.junit.Assert;

public class AccountAssertions {

    private AccountAssertions() {
    }

    public static void validateEndpointResponse(
            Response response) {

        Assert.assertTrue(
                response.statusCode() > 0
        );

        Assert.assertEquals(
                "application/json",
                response.getContentType().split(";")[0]
        );

        Assert.assertNotNull(
                response.getBody()
        );

        Assert.assertTrue(
                response.asString().length() > 0
        );
    }
}