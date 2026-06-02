package com.advantage.api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductClient {

    public Response getAllProducts() {

        return given()
                .log().all()
                .when()
                .get("/catalog/api/v1/products")
                .then()
                .log().all()
                .extract()
                .response();
    }
}