@cart
Feature: Cart Test Cases

  Scenario: Check action add to cart
    Given go to Home page
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    Then verify Cart page is displayed
    Then verify product is added to cart
      | name         | price     |
      | Adidas Alpha | 5,000,000 |

  Scenario: Check action update items in cart page
    Given go to Home page
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And change size and quantity of product
      | name         | price     | size | quantity |
      | Adidas Alpha | 5,000,000 | 37   | 2        |
    And click on button Cập nhật
    When go to Home page
    And go to Cart page
    Then verify size and quantity of product
      | name         | price     | size | quantity |
      | Adidas Alpha | 5,000,000 | 37   | 2        |