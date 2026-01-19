@web
Feature: Login

  @login
  Scenario: Login with valid credentials
    Given user accesses the login page
    When user logs in with valid username and password
    Then the system should display the home page
