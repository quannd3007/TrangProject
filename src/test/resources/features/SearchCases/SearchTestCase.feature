@search
Feature: Search Test Cases

  Scenario Outline: Check action search with brand on menu
    Given go to Home page
    And click on <branch> brand in menu bar
    Then the screen displays products match with <branch> branch

    Examples:
      | branch       |
      | Adidas       |
      | Bitis Hunter |
      | Converse     |

  Scenario Outline: Check action search with price on left menu
    Given go to Home page
    And search products with price <price> on left menu
    Then the screen displays products match with <price> price

    Examples:
      | price        |
      | Dưới 1 triệu |
      | 1-2 triệu    |
      | 2-5 triệu    |
      | 5-10 triệu   |

  Scenario Outline: Check action search with discount on left menu
    Given go to Home page
    And search products with discount <discount> on left menu
    Then the screen displays products match with <discount> discount

    Examples:
      | discount |
      | 20% off  |
      | 30% off  |
      | 50% off  |

  Scenario Outline: Check action search in search box
    Given go to Home page
    And search with keyword <keyword>
    Then the screen displays products match with <keyword> keyword

    Examples:
      | keyword            |
      | Adidas             |
      | Adidas Ultra Boost |