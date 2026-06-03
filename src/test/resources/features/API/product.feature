@api
Feature: Product API

  Scenario: CT008 - Get categories
    Given I request categories
    Then the API should return status 200

  Scenario: CT009 - Get deals
    Given I request deals
    Then the API should return status 200