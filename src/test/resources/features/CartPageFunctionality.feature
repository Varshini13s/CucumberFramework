Feature: Verify Add to Cart button functionality

  Scenario: Verify cart icon quantity and the number of products in cart page are equal
    Given user open website
    Then verify user is on login page
    When user login with username "standard_user" and password "secret_sauce"
    Then verify user is on home page
    When user click on all the items to cart
    Then verify cart icon quantity is equal to number of items user added
    When user click on cart icon
    Then verify user is on cart page
    And verify cart page total item is equal to number of items user added