package com.advantage.api.client;

import com.advantage.api.context.ApiContext;
import com.advantage.api.model.LoginRequest;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AccountClient {

    private final ApiContext context = ApiContext.getInstance();

    @Step("POST - Login")
    public Response login(LoginRequest request) {

        String url =
                "/accountservice/accountrest/api/v1/login";

        context.setRequestMethod("POST");
        context.setRequestUrl(url);
        context.setRequestBody(request.toString());

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(request)
                        .when()
                        .post(url)
                        .then()
                        .extract()
                        .response();

        context.setResponse(response);

        return response;
    }

    @Step("GET - Health Check")
    public Response healthCheck() {

        String url =
                "/accountservice/accountrest/api/v1/health-check";

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