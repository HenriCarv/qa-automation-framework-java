package com.advantage.api.services;

import com.advantage.api.client.ProductClient;
import io.restassured.response.Response;

public class ProductService {

    private final ProductClient client = new ProductClient();

    public Response getAllProducts() {
        return client.getAllProducts();
    }

    public Response getProductById(int id) {
        return client.getProductById(id);
    }

    public Response getCategories() {
        return client.getCategories();
    }

    public Response getDeals() {
        return client.getDeals();
    }
}