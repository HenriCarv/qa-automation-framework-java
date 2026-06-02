Feature: Product API

  Scenario: Get categories
    Given I request categories
    Then the API should return status 200

  Scenario: Get deals
    Given I request deals
    Then the API should return status 200