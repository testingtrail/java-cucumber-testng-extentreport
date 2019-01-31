#**************************************************************************
#Author: Jorge Quiros
#Last updated:
#Description: Feature file with all the scenarios/test cases
#**************************************************************************

Feature: Smartbox French web site
  This feature will test some features within the Smartbox French site

  Scenario: As a Customer I want a desired box and add it to the cart so I can make
            adjustments prior to checkout
    Given I am on a product page
    When I click on Ajouter au panier
    And I enter "ASCI White" as computer in filter
    Then I should see the result in the table for "ASCI White"

  Scenario: Check a new computer can be added to the system
    Given I navigate to the home page
    When I see Play Sample Application Header Link
    And I click on Add New computer button
    Then I should see Add new Computer page
    And I enter the following values for computer
      | Computer    | Introduced   | Discontinued | Company |
      | aaa Test    | 2017-02-02   | 2018-05-07   | Canon   |
    And Click on Create this computer
    And I enter "aaa Test" as computer in filter
    Then I should see the result in the table for "aaa Test"

  Scenario: Update an existing computer
    Given I navigate to the home page
    When I see Play Sample Application Header Link
    And I enter "aaa Test" as computer in filter
    Then I should see the result in the table for "aaa Test"
    And click on "aaa Test" computer link
    Then I should see Edit Computer page
    And I update the following values for computer
      | Computer     | Introduced   |  Company      |
      | aaa Test1    | 2017-03-02   |  Apple Inc.   |
    And Click on Save this computer
    And I enter "aaa Test1" as computer in filter
    Then I should see the result in the table for "aaa Test1"

  Scenario: Delete an existing computer
    Given I navigate to the home page
    When I see Play Sample Application Header Link
    And I enter "aaa Test1" as computer in filter
    Then I should see the result in the table for "aaa Test1"
    And click on "aaa Test1" computer link
    Then I should see Edit Computer page
    And Click on Delete this computer
    And I enter "aaa Test1" as computer in filter
    Then I should not see the result in the table for "aaa Test1"

