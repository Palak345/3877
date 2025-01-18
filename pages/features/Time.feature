Feature: Time Management
  This feature allows users to manage time entries, including viewing timesheets, adding new entries, and deleting entries.

  Scenario: View Timesheets
    Given User navigates to the "Time" section
    Then The "Timesheets" page should be displayed

  Scenario: Add a New Time Entry
    Given User navigates to the "Time" section
    When User adds a new time entry with project "Project X", activity "Development", and hours "8"
    Then The time entry should be successfully added

  Scenario: Delete a Time Entry
    Given User navigates to the "Time" section
    When User deletes a time entry with project "Project X" and activity "Development"
    Then The time entry should no longer be listed
