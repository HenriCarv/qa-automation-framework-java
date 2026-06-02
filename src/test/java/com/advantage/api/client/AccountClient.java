package com.advantage.api.client;

import com.advantage.api.model.LoginRequest;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AccountClient {

    @Step("Login na API")
    public Response login(LoginRequest request) {

        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/accountservice/accountrest/api/v1/login")
                .then()
                .extract()
                .response();
    }

    @Step("Health Check")
    public Response healthCheck() {

        return given()
                .log().all()
                .when()
                .get("/accountservice/accountrest/api/v1/health-check")
                .then()
                .extract()
                .response();
    }
}