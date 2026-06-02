package com.advantage.api.tests;

import com.advantage.api.client.ProductClient;
import com.advantage.api.utils.ApiConfig;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductApiTest {

    private static ProductClient productClient;

    @BeforeClass
    public static void setup() {

        ApiConfig.setup();
        productClient = new ProductClient();
    }

    @Test
    public void shouldGetProducts() {

        Response response =
                productClient.getAllProducts();

        response.prettyPrint();

        Assert.assertEquals(
                200,
                response.statusCode()
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