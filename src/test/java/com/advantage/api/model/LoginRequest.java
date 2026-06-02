package com.advantage.api.model;

public class LoginRequest {

    private String loginUser;
    private String loginPassword;

    public LoginRequest(String loginUser, String loginPassword) {
        this.loginUser = loginUser;
        this.loginPassword = loginPassword;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
}