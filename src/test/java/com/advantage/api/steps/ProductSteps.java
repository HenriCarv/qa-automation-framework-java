package com.advantage.api.steps;

import com.advantage.api.assertions.ProductAssertions;
import com.advantage.api.services.ProductService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class ProductSteps {

    private final ProductService service = new ProductService();
    private Response response;

    @Given("I request categories")
    public void requestCategories() {
        response = service.getCategories();
    }

    @Given("I request deals")
    public void requestDeals() {
        response = service.getDeals();
    }

    @Then("the API should return status 200")
    public void validateStatus200() {
        ProductAssertions.validateSuccessResponse(response);
    }

    @Then("the product contract should be valid")
    public void validateProductSchema() {
        ProductAssertions.validateProductsSchema(response);
    }
}