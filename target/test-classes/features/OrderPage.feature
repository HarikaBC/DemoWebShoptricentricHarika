Feature: OrderPage Search 
@OrderTest
Scenario: Order a product Successfully
Given User is on Home Page to order
When User visit cart for ordering the product and will checkout
When User should fill billing adress and details and payment method
When User orders the product 
Then Order details is displayed 