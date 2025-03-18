Feature: Shopping cart Page
@ShoppingCartTest
  Scenario: Automate adding items to the cart, removing them
    Given User Entered homepage
    When User opened product  added to cart and opened the cart
    When User removes the product and updates the quantities
    Then Checkout page is displayed