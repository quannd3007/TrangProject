@checkout
Feature: Checkout Test Cases

  Scenario: Check validate all fileds
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Đặt Hàng
    And delete all field
    And click on button Xác nhận
    Then verify message required fields is displayed

  Scenario: Check all customer information/shipping information in checkout page
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Đặt Hàng
    Then verify customer name displays as Đỗ Thu Trang
    Then verify customer mobile displays as 0373872918
    Then verify customer email displays as tt722100@gmail.com
    Then verify customer address displays as Canh nậu

    Then verify receiver name displays as Đỗ Thu Trang
    Then verify receiver mobile displays as 0373872918
    Then verify receiver address displays as Canh nậu

  Scenario: Check action update customer infomation
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Đặt Hàng
    And update receiver name to Đỗ Thu Trang 1
    And update receiver mobile to 03738729181
    And update receiver address to Canh nậu 1

    And click on button Xác nhận

    Then verify customer name displays as Đỗ Thu Trang
    Then verify customer mobile displays as 0373872918
    Then verify customer email displays as tt722100@gmail.com
    Then verify customer address displays as Canh nậu

    Then verify receiver name displays as Đỗ Thu Trang 1
    Then verify receiver mobile displays as 03738729181
    Then verify receiver address displays as Canh nậu 1

  Scenario: Check payment method
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Đặt Hàng
    And select payment method as Thanh toán trực tiếp khi giao hàng
    Then verify payment method Thanh toán trực tiếp khi giao hàng is selected

  Scenario: Check order successfully
    Given go to Home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    And click add to cart of product
      | name         | price     |
      | Adidas Alpha | 5,000,000 |
    And click on button Đặt Hàng
    And click on button Xác nhận đặt hàng
    Then message Hàng đã đặt thành công! Chúng tôi sẽ giao hàng sớm nhất cho bạn is displayed
    Then verify the order has been placed is displayed
    And login to Admin page
    And go to Tất cả đơn hàng page
    Then verify the order has been placed is displayed in list