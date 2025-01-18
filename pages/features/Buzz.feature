Feature: Buzz Management
  This feature allows users to interact with the Buzz module, including viewing posts, adding new posts, and liking posts.

  Scenario: View Buzz posts
    Given User navigates to the "Buzz" section
    Then The "Buzz" page should display a list of posts

  Scenario: Add a new Buzz post
    Given User navigates to the "Buzz" section
    When User adds a new Buzz post with content "Excited for the weekend team-building activity!"
    Then The post should be successfully added to the Buzz feed

  Scenario: Like a Buzz post
    Given User navigates to the "Buzz" section
    When User likes the first post in the Buzz feed
    Then The like count for the post should increase
