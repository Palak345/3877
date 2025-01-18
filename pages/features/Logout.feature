Feature: Logout functionality

  Scenario: User logs out successfully
    Given User is logged into the application
    When User clicks on the logout button
    Then User should be redirected to the login page
