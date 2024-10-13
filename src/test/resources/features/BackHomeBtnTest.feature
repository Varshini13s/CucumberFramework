Feature: Verify Back Home Button in the application

  Scenario: Verify Remove Button is not present after clicking Back Home Button
    Given user open website
    Then verify user is on login page
    When user login with username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When user click on add to cart button of the first item
    When user click on cart icon
    Then verify user is on cart page
    When user click on checkout button
    Then verify user is on checkout page
    When user fill all checkout details
    And click on Continue button
    Then verify user is on review page
    When user click on Finish button
    Then verify user is on order confirmation page
    When user click on Back Home Button
    Then verify user is on home page
    And verify remove button is not present