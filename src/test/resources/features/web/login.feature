@web
Feature: Login

  As a Advantage Shopping user
  I want to log into the system
  So that I can view the home page

  Background:
    Given the user accesses the Advantage Shopping website

  Scenario: CT001 - Login with valid credentials
    When the user logs in with valid credentials
    Then the user should see the home page

  Scenario: CT002 - Login with invalid username
    When the user enters an invalid username 'teste1234' and valid password 'Teste@123'
    Then the user should see the error message 'Incorrect user name or password.'

  Scenario: CT003 - Login with invalid password
    When the user enters an invalid username 'teste123' and valid password 'Teste@1234'
    Then the user should see the error message 'Incorrect user name or password.'

  Scenario: CT004 - Validate required username and password fields
    When the user opens the login modal
    And clicks on username field
    And clicks on password field
    And clicks outside the login fields
    Then the username required message should be "Username field is required"
    And the password required message should be "Password field is required"