Feature: Check creation account with empty fields

  Scenario: Successful creation account with empty fields
    Given  Customer is on page with url 'homepage.url'
    When Customer opens Sing In page
    And Open Create your Amazon account page
    And Click Create your Amazon account button
    Then Check if there is validation of fields
