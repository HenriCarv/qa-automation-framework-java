Feature: Account API

  Scenario: Validate login
    Given I perform a valid login
    Then the endpoint should respond correctly

  Scenario: Validate health check
    Given I request health check
    Then the endpoint should respond correctly