package com.advantage.api.context;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ApiContext {

    private static ApiContext instance;

    private String requestMethod;
    private String requestUrl;
    private Object requestBody;
    private Map<String, String> requestHeaders = new HashMap<>();
    private Response response;

    private ApiContext() {}

    public static ApiContext getInstance() {
        if (instance == null) {
            instance = new ApiContext();
        }
        return instance;
    }

    public void clear() {
        requestMethod = null;
        requestUrl = null;
        requestBody = null;
        requestHeaders.clear();
        response = null;
    }

    // GETTERS / SETTERS

    public String getRequestMethod() { return requestMethod; }
    public void setRequestMethod(String requestMethod) { this.requestMethod = requestMethod; }

    public String getRequestUrl() { return requestUrl; }
    public void setRequestUrl(String requestUrl) { this.requestUrl = requestUrl; }

    public Object getRequestBody() { return requestBody; }
    public void setRequestBody(Object requestBody) { this.requestBody = requestBody; }

    public Map<String, String> getRequestHeaders() { return requestHeaders; }

    public Response getResponse() { return response; }
    public void setResponse(Response response) { this.response = response; }
}