Feature: Finding cheese on google search

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then I should see the number of search results