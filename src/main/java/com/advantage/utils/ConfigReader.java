package com.advantage.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try {

            properties.load(
                    new FileInputStream(
                            "src/test/resources/config/config.properties"
                    )
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Erro ao carregar config.properties",
                    e
            );
        }
    }

    public static String get(String key) {

        return properties.getProperty(key);
    }
}