package com.advantage.api.utils;

import io.restassured.RestAssured;

public class ApiConfig {

    private ApiConfig() {
    }

    public static void setup() {

        RestAssured.baseURI =
                "https://www.advantageonlineshopping.com";
    }
}