Feature: product searching
  customer should be able to use product search

  Scenario Outline: Successful Direct Hit Search
    Given Customer is on page with url 'homepage.url'
    When Customer performs search for '<search_item>'
    Then Check text '<search_expected_department>' in department field

    Examples:
    |     search_item           |search_expected_department|
    |search.term.children.books |search.books.department   |
    |search.term.by.author.king |search.books.department   |
    |search.term.romantic.book  |search.books.department   |


    Scenario: Successful search by category
      Given Customer is on page with url 'homepage.url'
      When Customer selects category 'search.category.value'
      And Search by category
      Then Check if category is right 'search.category.text'


  Scenario Outline: Negative scenario search by category
    Given Customer is on page with url 'homepage.url'
    When Customer selects category by visible text '<search_category_by_text>'

    Examples:
    |search_category_by_text |
    |search.category.by.text.page.factory |
    |search.category.by.text.space        |


