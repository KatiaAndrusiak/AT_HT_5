Feature: Add product to the cart and remove
  Every anonymous customer has possibility to find and add product to the cart and remove

  Scenario: Successful scenario add product to the cart
    Given  Customer is on page with url 'homepage.url'
    When Customer performs search for 'search.term.children.books'
    And Open selected product item
    And Add item to the basket
    Then Check if item is added to the basket


  Scenario: Successful scenario add product to the cart and then remove
    Given  Customer is on page with url 'homepage.url'
    When Customer performs search for 'search.term.children.books'
    And Open selected product item
    And Add item to the basket
    Then Open basket
    And Remove product from basket
    Then Check if item is removed from the basket
