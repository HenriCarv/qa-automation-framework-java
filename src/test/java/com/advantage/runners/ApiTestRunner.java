package com.advantage.runners;

import com.advantage.api.tests.AccountApiTest;
import com.advantage.api.tests.ProductApiTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        ProductApiTest.class,
        AccountApiTest.class

})
public class ApiTestRunner {
}