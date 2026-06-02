package com.advantage.api.client;

import com.advantage.api.context.ApiContext;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductClient {

    private final ApiContext context = ApiContext.getInstance();

    @Step("GET - All products")
    public Response getAllProducts() {

        String url = "/catalog/api/v1/products";

        context.setRequestMethod("GET");
        context.setRequestUrl(url);
        context.setRequestBody(null);

        Response response =
                given()
                        .when()
                        .get(url)
                        .then()
                        .extract()
                        .response();

        context.setResponse(response);

        return response;
    }

    @Step("GET - Product by ID")
    public Response getProductById(int id) {

        String url = "/catalog/api/v1/products/" + id;

        context.setRequestMethod("GET");
        context.setRequestUrl(url);
        context.setRequestBody(null);

        Response response =
                given()
                        .when()
                        .get(url)
                        .then()
                        .extract()
                        .response();

        context.setResponse(response);

        return response;
    }

    @Step("GET - Categories")
    public Response getCategories() {

        String url = "/catalog/api/v1/categories";

        context.setRequestMethod("GET");
        context.setRequestUrl(url);
        context.setRequestBody(null);

        Response response =
                given()
                        .when()
                        .get(url)
                        .then()
                        .extract()
                        .response();

        context.setResponse(response);

        return response;
    }

    @Step("GET - Deals")
    public Response getDeals() {

        String url = "/catalog/api/v1/deals";

        context.setRequestMethod("GET");
        context.setRequestUrl(url);
        context.setRequestBody(null);

        Response response =
                given()
                        .when()
                        .get(url)
                        .then()
                        .extract()
                        .response();

        context.setResponse(response);

        return response;
    }
}