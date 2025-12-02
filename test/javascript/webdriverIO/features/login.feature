Feature: Sauce Demo Login Tests

  Scenario Outline: As a user, I can successfully log into the store
    Given I am on the login page
    When I login with <username> and <password>
    Then I should be on the inventory page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: As a user, I see an error with invalid credentials
    Given I am on the login page
    When I login with <username> and <password>
    Then I should see an error message saying <message>

    Examples:
      | username        | password     | message                                                                     |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                         |
      | standard_user   | wrong_pass   | Epic sadface: Username and password do not match any user in this service   |
