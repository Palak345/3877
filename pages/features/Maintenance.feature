Feature: Manage Maintenance Records
  This feature allows users to view, add, and delete maintenance records.

  Scenario: View Maintenance Records
    Given User navigates to the "Maintenance" section
    Then The "Maintenance" page should be displayed

  Scenario: Add a New Maintenance Record
    Given User navigates to the "Maintenance" section
    When User adds a maintenance record with type "System Check" and description "Routine Check"
    Then The record should be successfully added

  Scenario: Delete a Maintenance Record
    Given User navigates to the "Maintenance" section
    When User deletes a maintenance record with type "System Check"
    Then The record should no longer be listed
