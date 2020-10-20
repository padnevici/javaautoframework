Feature: test google search page

  Scenario: check that google search page returns ressults accordiong to search criteria
    Given user is on Home page
    When user clicks on get offer button
    Then user is on Questionary - Question1 page
    When user continues wizard
    Then user is on Questionary - Question2 page
    When user set family composition
      | adults | children |
      | 2      | 2        |
