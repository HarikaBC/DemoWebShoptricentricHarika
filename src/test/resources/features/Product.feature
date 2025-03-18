Feature: product Functionality
@ProductPageTest
  Scenario: Validate the product 
    Given User Entered the homepage
    When User search for the product
    When User filters the results
    When User validate the product
    When User adding the quantity of product 
    When User adding the product to the cart
    Then Product is displayed in the cart