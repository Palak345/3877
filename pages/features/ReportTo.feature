Feature: Manage Report-to Section

  Scenario: Verify Assigned Subordinates Section
    Given User navigates to the "Report-to" section
    Then The "Assigned Subordinates" section should be displayed

  Scenario: Add a New Subordinate
    Given User navigates to the "Report-to" section
    When User adds a subordinate with name "Palak Mangal" and reporting method "Direct"
    Then The subordinate "Palak Mangal" should be displayed in the list

  Scenario: Delete a Subordinate
    Given User navigates to the "Report-to" section
    When User deletes the subordinate "Sara Tencrady"
    Then The subordinate "Sara Tencrady" should not be displayed in the list

  Scenario: Upload an Attachment
    Given User navigates to the "Attachments" section
    When User uploads an attachment with the file path "/path/to/file.txt"
    Then The attachment should be successfully uploaded

  Scenario: Verify No Attachments Message
    Given User navigates to the "Attachments" section
    Then The message "No Records Found" should be displayed if no attachments exist
