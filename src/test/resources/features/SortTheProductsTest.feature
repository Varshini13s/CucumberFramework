Feature: Verify products are sorted according to the options in Home Page
  Background:
    Given user open website
    Then verify user is on login page
    When user login with username "standard_user" and password "secret_sauce"
    Then verify user is on home page

  Scenario: Verify user can sort products from Z to A
    When user clicks on A to Z sort button
    Then verify products are sorted by Z to A

  Scenario: Verify user can sort products from high to low price
    When user clicks on high to low sort button
    Then verify products are sorted from high to low price
