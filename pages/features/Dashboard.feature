Feature: Dashboard Navigation

  Background: User is logged in
    Given I open the OrangeHRM application
    When I enter username "Admin" and password "admin123"
    And I click the login button
    Then I should see the dashboard

  Scenario: Navigate to Admin Module
    When I click on the Admin Module
    Then I should be on the Admin page

  Scenario: Navigate to PIM Module
    When I click on the PIM Module
    Then I should be on the Employee List page

  Scenario: Navigate to Leave Module
    When I click on the Leave Module
    Then I should be on the Leave page
