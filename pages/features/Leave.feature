Feature: Leave Management

  Background: Logged in to the OrangeHRM Dashboard
    Given I navigate to the OrangeHRM login page
    And I log in with "Admin" and "admin123"

  Scenario: Assign leave to an employee
    When I navigate to "Assign Leave"
    And I assign leave to "palak mangal" with type "Annual Leave" from "2025-01-20" to "2025-01-25"
    Then I should see a success message confirming the leave was assigned
