Feature: Shopping
  Scenario: User should be able to login with credentials, then select a product and add it to cart
    Given Browser is open
    And User is on "http://automationpractice.com/" page
    When User clicks on sign in
    And User login with valid credentials
    Then User logged in successfully
    Then Women category is open
    Then Tops and Dresses categories seen
    Then Go to 5th product on the list
    Then Add 3 times
    Then Add to cart
    Then Proceed to checkout
    Then Check Total "$86.94", Total Products "$86.94" and Quantity "3"


