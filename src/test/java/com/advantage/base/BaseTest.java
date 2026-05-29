package com.advantage.base;

import com.advantage.drivers.DriverFactory;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() {
        // 🔥 abre o navegador antes de cada teste
        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        // 🔥 fecha o navegador depois de cada teste
        DriverFactory.quitDriver();
    }
}