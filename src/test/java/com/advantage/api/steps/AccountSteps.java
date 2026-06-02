package com.advantage.api.steps;

import com.advantage.api.data.ApiTestData;
import com.advantage.api.services.AccountService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class AccountSteps {

    private final AccountService service = new AccountService();
    private Response response;

    @Given("I perform a valid login")
    public void loginValid() {
        response = service.login(
                ApiTestData.VALID_USER,
                ApiTestData.VALID_PASSWORD
        );
    }

    @Given("I request health check")
    public void healthCheck() {
        response = service.healthCheck();
    }

    @Then("the endpoint should respond correctly")
    public void validate() {

        Assert.assertTrue(response.statusCode() > 0);

        Assert.assertEquals(
                "application/json",
                response.contentType().split(";")[0]
        );

        Assert.assertNotNull(response.getBody());
    }
}