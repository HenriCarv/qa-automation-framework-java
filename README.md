# QA Automation Framework - Advantage Online Shopping

## Overview

Automation framework developed to validate Web and API functionalities of the Advantage Online Shopping application.

The project was created using Java, Selenium, Rest Assured, Cucumber (BDD), Allure Reports, SQLite and GitHub Actions following Page Object and Service Layer design patterns.

---

## Technologies

### Web Automation

* Java 17
* Selenium WebDriver 4
* WebDriverManager

### API Automation

* Rest Assured

### BDD

* Cucumber
* Gherkin

### Reports

* Allure Report

### Test Data

* Java Faker

### Database

* SQLite

### CI/CD

* GitHub Actions

### Build Tool

* Maven

---

## Project Structure

```text
## Project Structure

```text
qa-automation-framework-java
│
├── src
│   ├── test
│   │   ├── java
│   │   │
│   │   ├── web
│   │   │   ├── pages
│   │   │   ├── steps
│   │   │   ├── runners
│   │   │   ├── hooks
│   │   │   └── assertions
│   │   │
│   │   ├── api
│   │   │   ├── client
│   │   │   ├── service
│   │   │   ├── steps
│   │   │   ├── assertions
│   │   │   ├── hooks
│   │   │   ├── schema
│   │   │   └── context
│   │   │
│   │   ├── config
│   │   │
│   │   ├── database
│   │   │   └── SQLiteManager
│   │   │
│   │   └── utils
│   │
│   └── resources
│       ├── features
│       │   ├── api
│       │   └── web
│       │
│       ├── schemas
│       ├── log4j2.xml
│       └── allure.properties
│
├── target
│   ├── allure-results
│   └── allure-report
│
├── execution.db
├── pom.xml
├── .gitignore
├── README.md
└── .github
    └── workflows
        └── automation.yml
```

---

## Design Patterns

The framework follows:

* Page Object Pattern
* Service Layer Pattern
* Factory Pattern
* Singleton Pattern (Context and Database)

Benefits:

* Better maintainability
* Reusability
* Scalability
* Cleaner test implementation

---

## Web Test Coverage

### Login

* Valid login
* Invalid login

### Product Selection

* Search product
* Open product details

### Cart

* Add product to cart
* Validate selected product

### Checkout

* Checkout flow validation
* Product information validation
* Quantity validation
* Price validation

---

## API Test Coverage

### Account API

Endpoint:

```text
/accountservice/accountrest/api/v1/login
```

Validations:

* Status Code
* Response Headers
* Response Body

---

Endpoint:

```text
/accountservice/accountrest/api/v1/health-check
```

Validations:

* Status Code
* Response Headers
* Response Body

---

### Product API

Endpoints:

```text
/catalog/api/v1/products
/catalog/api/v1/products/{id}
/catalog/api/v1/categories
/catalog/api/v1/deals
```

Validations:

* Status Code
* Response Headers
* Response Content
* JSON Schema Validation

---

## Test Data Management

The project uses:

* Java Faker for dynamic data generation
* Centralized data classes
* Reusable test data

This approach reduces maintenance effort and avoids hardcoded values.

---

## Logging

The framework records:

### Request

* HTTP Method
* URL
* Headers
* Body

### Response

* Status Code
* Headers
* Body

All information is available inside the Allure Report.

---

## Database Integration

SQLite is used to store execution information.

Stored data:

* Endpoint
* HTTP Method
* Status Code
* Response Time
* Execution Result
* Timestamp

Database file:

```text
execution.db
```

---

## Reports

The framework uses Allure Report.

Generate report:

```bash
mvn allure:report
```

Open report:

```bash
mvn allure:serve
```

---

## Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run API Tests

```bash
mvn test -Dcucumber.filter.tags="@api"
```

### Run Web Tests

```bash
mvn test -Dcucumber.filter.tags="@web"
```

---

## Continuous Integration

The project is integrated with GitHub Actions.

Pipeline execution includes:

* Checkout
* Maven Build
* Test Execution
* Allure Report Generation
* Log Collection
* SQLite Database Artifact Upload

Workflow location:

```text
.github/workflows/automation-tests.yml
```

---

## Evidence

The framework automatically generates:

* Screenshots (Web)
* Allure Report
* Execution Logs
* SQLite Execution Records

---

## How to Clone

```bash
git clone https://github.com/HenriCarv/qa-automation-framework-java.git
```

Enter the project:

```bash
cd qa-automation-framework-java
```

Run tests:

```bash
mvn clean test
```

---

## Author

Henrique Carvalho

QA Automation Engineer
