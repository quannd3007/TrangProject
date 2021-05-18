@search
Feature: Search Test Cases

  Scenario Outline: Check action search in search box
    Given go to Home page
    And search with keyword <keyword>
    Then the screen displays products match with <keyword> keyword

    Examples:
      | keyword            |
      | Adidas             |
      | Adidas Ultra Boost |