Feature: Performance Management
  This feature allows users to manage performance reviews, including adding new reviews, viewing performance details, and searching for records.

  Scenario: View Performance details
    Given User navigates to the "Performance" section
    Then The "Performance" page should display a list of performance reviews

  Scenario: Add a new Performance review
    Given User navigates to the "Performance" section
    When User adds a performance review for employee "John Doe" with review period "2024-01-01 to 2024-12-31" and comments "Exceeds expectations"
    Then The performance review should be successfully added

  Scenario: Search for Performance records
    Given User navigates to the "Performance" section
    When User searches for performance records of employee "Jane Smith"
    Then The search results should display the performance reviews of "Jane Smith"
