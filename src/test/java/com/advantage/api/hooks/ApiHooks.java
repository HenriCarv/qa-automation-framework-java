package com.advantage.api.hooks;

import com.advantage.api.config.ApiConfig;
import com.advantage.api.context.ApiContext;
import io.cucumber.java.Before;

public class ApiHooks {

    @Before(order = 0)
    public void setupApi() {
        ApiConfig.init();
        ApiContext.getInstance().clear();
    }
}