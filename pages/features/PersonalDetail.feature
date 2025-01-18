Feature: Personal Details update functionality

  Scenario: User updates personal details successfully
    Given User is on the Personal Details page
    When User updates personal details with first name "John", last name "Doe", and employee ID "12345"
    Then A success message should be displayed saying "Successfully Saved"
