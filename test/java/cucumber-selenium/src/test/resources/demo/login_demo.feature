@REQ_LOGIN-9345
Feature: SauceDemo Login

  Scenario: Verify successful login with valid credentials
    Given I navigate to the saucedemo website
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page
