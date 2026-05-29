Feature: Login

  As a Advantage Shopping user
  I want to log into the system
  So that I can view the home page

  Background:
    Given the user accesses the Advantage Shopping website

  Scenario: Login with valid credentials
    When the user logs in with valid credentials
    Then the user should see the home page