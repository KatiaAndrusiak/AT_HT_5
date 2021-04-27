Feature: Change currency
  Every anonymous customer has possibility to change currency

  Scenario: Successful scenario change currency
    Given  Customer is on page with url 'homepage.url'
    When Open change currency page
    And Select currency 'currency.value.to.change'
    And Save selected currency
    Then Check if currency is changed