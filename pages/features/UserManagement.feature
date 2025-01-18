Feature: User Management

  Scenario: Updating personal details successfully
    Given User is on the Personal Details page
    When User updates personal details with first name "John", last name "Doe", and employee ID "12345"
    Then A success message should be displayed saying "Successfully Saved"

  Scenario: Generating a report
    Given User is on the Reports page
    When User generates a report
    Then The report status should be "Report generated successfully"

  Scenario: Logging out of the application
    Given User is logged into the application
    When User clicks on the logout button
    Then User should be redirected to the login page
