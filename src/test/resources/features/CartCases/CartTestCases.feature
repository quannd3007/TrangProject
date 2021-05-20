@cart
Feature: Cart Test Cases

  Scenario: Check action add to cart
    Given go to Home page
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    Then verify Cart page is displayed
    Then verify product is displayed on Cart page
      | name         | price     |
      | Adidas Alpha | 5,000,000 |

  Scenario: Check action update items in cart page
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And change size and quantity of product
      | name         | price     | size | quantity |
      | Adidas Alpha | 5,000,000 | 37   | 2        |
    And click on button Cập nhật
    When go to Home page
    And click on button Giỏ hàng của tôi
    Then verify size and quantity of product
      | name         | price     | size | quantity |
      | Adidas Alpha | 5,000,000 | 37   | 2        |

  Scenario: Check action delete item
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on delete icon of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    Then verify delete popup is displayed
    And click on button Hủy on delete popup
    Then verify delete popup is not displayed
    Then verify product is displayed on Cart page
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Xóa tất cả
    Then verify delete popup is displayed
    And click on button OK on delete popup
    Then verify the message Bạn đã xóa tất cả sản phẩm trong giỏ! is displayed

  Scenario: Check action deleted all items
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Xóa tất cả
    Then verify delete popup is displayed
    And click on button Hủy on delete popup
    Then verify delete popup is not displayed
    Then verify product is displayed on Cart page
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Xóa tất cả
    Then verify delete popup is displayed
    And click on button OK on delete popup
    Then verify product is not displayed on Cart page
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    Then verify the screen displayed message Giỏ hàng trống
    Then verify the message Bạn đã xóa tất cả sản phẩm trong giỏ! is displayed