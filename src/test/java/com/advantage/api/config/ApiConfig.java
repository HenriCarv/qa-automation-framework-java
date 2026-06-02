package com.advantage.api.config;

import io.restassured.RestAssured;

public class ApiConfig {

    public static void init() {

        RestAssured.baseURI = "https://www.advantageonlineshopping.com";

        RestAssured.filters(new AllureRestAssuredFilter());
    }
}