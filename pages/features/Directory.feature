Feature: Employee Directory
  This feature allows users to search for employees in the directory.

  Scenario: Search for an Employee
    Given User navigates to the "Directory" section
    When User searches for an employee with name "Palak Mangal"
    Then The employee's information should be displayed

  Scenario: Verify Non-Existent Employee
    Given User navigates to the "Directory" section
    When User searches for an employee with name "Non Existent"
    Then No results should be displayed
