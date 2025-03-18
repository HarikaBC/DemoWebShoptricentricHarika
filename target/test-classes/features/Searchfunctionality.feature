Feature: Search Functionality
@SearchFunctionality
  Scenario: Automate searching for products, filtering results by Discounts, price, and Language 
    Given User is in the search page
    When User search for product
    When User filters the given results
    Then User should see the filtered results
    