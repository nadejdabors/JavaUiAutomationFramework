Feature: Register Flow Test Suite

  Scenario: Register Page can be accessed from the Home Page
    Given Home Page is displayed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: Access the Account Page after successful registration
    Given Home Page is displayed
    And registerLink from Header menu is clicked
    When the register form is populated with valid random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword


  Scenario: The user is remaining on Register page when trying to register with invalid password
    Given Home Page is displayed
    And  registerLink from Header menu is clicked
    When the register form is populated with invalid password
    And Continue button is clicked
    Then Error Message is displayed

  Scenario: The user is remaining on Register page when trying to register with invalid password
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    When the register form is populated with invalid password
    And Continue button is clicked
    Then Error Message is displayed


