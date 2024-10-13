Feature: Verify total price is correct in Review Page

  Scenario: Verify total price is equal to total price of items added and tax
    Given user open website
    Then verify user is on login page
    When user login with username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When user click on all the items to cart
    And user click on cart icon
    Then verify user is on cart page
    When user click on checkout button
    Then verify user is on checkout page
    When user fill all checkout details
    And click on Continue button
    Then verify total price is equal to sum of prices of items added and the tax
