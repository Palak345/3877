Feature: Employee Management

  Background: Logged in to the OrangeHRM Dashboard
    Given I navigate to the OrangeHRM login page
    And I log in with "Admin" and "admin123"

  Scenario: Add a new employee
    When I navigate to "Add Employee"
    And I add an employee with first name "Palak", last name "Mangal", and employee ID "12345"
    Then I should see the personal details page of the added employee
