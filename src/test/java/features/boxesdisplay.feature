#**************************************************************************
#Author: Jorge Quiros
#Last updated: 01/19/20
#Description: Feature file for boxes display user story
#**************************************************************************

Feature: Smartbox Boxes Display
  As a customer I want to view a list of products so I can select some to purchase

  Background:
    Given I am on the home page

  @smoke
  Scenario: As a Customer I search in the main field
    When I look for specific product "bistrots" in search box
    Then I should see suggestion for my search

  @smoke
  Scenario: As a Customer I can search in the filter box of sub category page
    Given I look for an specific product in the menu
    When Subcategory page product page appears
    Then I should see the filter options
    And I search on the box filter for Title "3 jours de"
    And Click on any Box
    Then A link for review section should appear

