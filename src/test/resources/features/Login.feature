Feature: Check login with invalid login

  Scenario Outline: Successful scenario error when login is invalid
    Given  Customer is on page with url 'homepage.url'
    When Customer opens Sing In page
    And Fill login field with '<login>'
    And Click on Continue button
    Then Check if there is error message

    Examples:
    |login|
    |invalid.login.number|
    |invalid.login.email |

