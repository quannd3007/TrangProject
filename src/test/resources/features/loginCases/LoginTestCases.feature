@login
Feature: Login Test Cases
  Scenario: Check login successfully with valid account
    Given go to home page
    And click on login button
    And input username as trangthu
    And input password as 123456
    And submit login
    Then verify username trangthu is displayed on menu bar
    Then verify login button is not displayed on menu bar

  Scenario: Check login unsuccessfully with invalid 'Tên người dùng'
    Given go to home page
    And click on login button
    And input username as thutrang
    And input password as 123456
    And submit login
    Then verify error message "Sai tên đăng nhập hoặc mật khẩu!" is displayed

  Scenario: Check login unsuccessfully with invalid 'Mật khẩu'
    Given go to home page
    And click on login button
    And input username as trangthu
    And input password as 654321
    And submit login
    Then verify error message "Sai tên đăng nhập hoặc mật khẩu!" is displayed

  Scenario Outline: Check login unsuccessfully with fields is blank
    Given go to home page
    And click on login button
    And input username as <username>
    And input password as <password>
    And submit login
    Then verify error message "Please fill out this field." is displayed

    Examples:
      | username | password |
      | trangthu |          |
      |          | 654321   |


