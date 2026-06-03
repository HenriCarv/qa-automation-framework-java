@api
Feature: Account API

  Scenario: CT006 - Validate login
    Given I perform a valid login
    Then the endpoint should respond correctly

  Scenario: CT007 - Validate health check
    Given I request health check
    Then the endpoint should respond correctly