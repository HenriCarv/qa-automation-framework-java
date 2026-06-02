package com.advantage.api.config;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class AllureRestAssuredFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        // REQUEST
        String requestInfo =
                "METHOD: " + requestSpec.getMethod() + "\n" +
                        "URL: " + requestSpec.getURI() + "\n" +
                        "HEADERS: " + requestSpec.getHeaders() + "\n" +
                        "BODY: " + requestSpec.getBody();

        Allure.addAttachment("API REQUEST", requestInfo);

        // EXECUTE
        Response response = ctx.next(requestSpec, responseSpec);

        // RESPONSE
        String responseInfo =
                "STATUS: " + response.getStatusCode() + "\n" +
                        "HEADERS: " + response.getHeaders() + "\n" +
                        "BODY: " + response.asPrettyString();

        Allure.addAttachment("API RESPONSE", responseInfo);

        return response;
    }
}