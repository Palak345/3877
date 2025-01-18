Feature: Login functionality

  Background: Navigate to OrangeHRM Login Page
    Given I navigate to the OrangeHRM login page

  Scenario: Successful login with valid credentials
    When I log in with "Admin" and "admin123"
    Then I should see the dashboard page

  Scenario: Login with invalid credentials
    When I log in with "InvalidUser" and "InvalidPassword"
    Then I should see an error message saying "Invalid credentials"
