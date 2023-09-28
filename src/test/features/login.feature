Feature: User is directed to the Pricing Page


  Scenario Outline: Login to Webpage

    Given User navigates to WebPage "https://saucedemo.com/"
    When User enters username "<username>" and password "<password>"
    Then User clicks the Login button
    Examples:
      | username | password|
      | standard_user | secret_sauce|

  Scenario Outline: Assert Validation message on Login

    Given User navigates to WebPage "https://saucedemo.com/"
    When User enters username "<username>" and password "<password>"
    And User clicks the Login button
    Then  User gets the validation message
    Examples:
      | username | password|
      | standard_user | 123|


  Scenario Outline: Add Product to Cart and Complete Order

    Given User navigates to WebPage "https://saucedemo.com/"
    When User enters username "<username>" and password "<password>"
    And User clicks the Login button
    Then User add product to cart
    Then User Open Cart
    Then Proceed Checkout
    Then Enter Contact Information
    Then Finish Order
    Then User completed order and gets success message validation
    Examples:
      | username | password|
      | standard_user | secret_sauce|