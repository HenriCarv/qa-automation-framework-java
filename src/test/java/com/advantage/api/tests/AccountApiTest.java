package com.advantage.api.tests;

import com.advantage.api.client.AccountClient;
import com.advantage.api.model.LoginRequest;
import com.advantage.api.utils.ApiConfig;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountApiTest {

    private static AccountClient accountClient;

    @BeforeClass
    public static void setup() {

        ApiConfig.setup();

        accountClient = new AccountClient();
    }

    @Test
    @Description("Validar endpoint de login")
    public void shouldCallLoginEndpoint() {

        LoginRequest request =
                new LoginRequest(
                        "test",
                        "Test123"
                );

        Response response =
                accountClient.login(request);

        System.out.println("STATUS CODE: " + response.statusCode());

        response.prettyPrint();

        Assert.assertNotNull(response);

        Assert.assertTrue(
                response.statusCode() > 0
        );
    }

    @Test
    @Description("Validar health check da API")
    public void shouldValidateHealthCheck() {

        Response response =
                accountClient.healthCheck();

        response.prettyPrint();

        Assert.assertEquals(
                200,
                response.statusCode()
        );

        Assert.assertEquals(
                "application/json",
                response.getContentType().split(";")[0]
        );

        Assert.assertTrue(
                response.asString().length() > 0
        );
    }
}