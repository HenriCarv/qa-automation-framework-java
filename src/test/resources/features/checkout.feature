Feature: Checkout

  As a user of the Advantage Shopping platform
  I want to complete a purchase
  So that I can successfully place an order

  Background:
    Given the user accesses the Advantage Shopping website

  Scenario: Successful checkout using a valid user
    When the user logs in with valid credentials
    And the user searches for a product
    And the user adds the product to the cart
    And the user opens the shopping cart
    And the user proceeds to checkout
    And the user fills in payment details
    And the user confirms the purchase
    Then the purchase should be completed successfully