package com.advantage.api.services;

import com.advantage.api.client.AccountClient;
import com.advantage.api.model.LoginRequest;
import io.restassured.response.Response;

public class AccountService {

    private final AccountClient client = new AccountClient();

    public Response login(String user, String password) {

        LoginRequest request = new LoginRequest(user, password);

        return client.login(request);
    }

    public Response healthCheck() {
        return client.healthCheck();
    }
}