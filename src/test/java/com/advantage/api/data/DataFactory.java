package com.advantage.api.data;

import java.util.Random;

public class DataFactory {

    public static String randomUser() {
        return "user_" + System.currentTimeMillis();
    }

    public static String randomPassword() {
        return "Pass@" + new Random().nextInt(9999);
    }
}