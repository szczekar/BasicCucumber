Feature: Checking login feature

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the login as "username" and password as "adminpassword"
    And I click login button
    Then I should see the userform page


  Scenario: Login with correct username and password with data table
    Given I navigate to the login page
    And I enter the following for Login
      | username | password |
      | admin    | admin    |
    And I click login button
    Then I should see the userform page


  Scenario Outline: Login with correct username and password outline
    Given I navigate to the login page
    And I enter <username> and <password>
    And I click login button
    Then I should see the userform page
    Examples:
      | username | password      |
      | admin    | adminpassword |
      | admin    | admin         |