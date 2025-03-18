Feature: HomePage Search 
@SearchTest
Scenario: Search for a product
Given User is on Home Page
When User searches for "Laptop"
Then Search results should be displayed