package com.advantage.api.client;

import com.advantage.api.model.LoginRequest;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AccountClient {

    @Step("Realizar login")
    public Response login(LoginRequest request) {

        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(request)
                .when()
                .post("/accountservice/accountrest/api/v1/login")
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Step("Validar health check")
    public Response healthCheck() {

        return given()
                .log().all()
                .when()
                .get("/accountservice/accountrest/api/v1/health-check")
                .then()
                .log().all()
                .extract()
                .response();
    }
}