Feature: Checkout

  As a user of the Advantage Shopping platform
  I want to complete a purchase
  So that I can successfully place an order

  Background:
    Given the user accesses the Advantage Shopping website
    And the user logs in with valid credentials

  Scenario: CT005 - Verify selected product is added to the shopping cart
    Then the user searches for a product
    And the user adds the product to the cart
    And the user opens the shopping cart
    And the selected product should be displayed in the shopping cart