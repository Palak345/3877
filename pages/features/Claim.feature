Feature: Manage Claims
  This feature allows users to view claims, submit new claims, and delete existing claims.

  Scenario: View Claims Section
    Given User navigates to the "Claims" section
    Then The "Claims" page should be displayed

  Scenario: Submit a New Claim
    Given User navigates to the "Claims" section
    When User submits a claim with type "Medical" and amount "500"
    Then The claim should be successfully submitted

  Scenario: Delete an Existing Claim
    Given User navigates to the "Claims" section
    When User deletes a claim with type "Medical"
    Then The claim should no longer be listed
