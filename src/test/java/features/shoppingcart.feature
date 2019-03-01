#**************************************************************************
#Author: Jorge Quiros
#Last updated:
#Description: Feature file for add to shopping cart display user story
#**************************************************************************

@skipped_temporal
Feature: Smartbox Shopping cart
  As a Customer I want to find a desired box and add it to the cart so I can make adjustments prior to checkout

  Background:
    Given I am on the home page

  @smoke
  Scenario: As a Customer I want a desired box and add a title to the cart so I can make adjustments
    Given I look for an specific product in the menu
    When Subcategory page product page appears
    And Click on any Box
    Then I click on Ajouter au panier
    And  options Continuer mes Achats, Voir le Panier and Vider le Panier appears on the add to cart overlay
    Then I click on voir le panier button
    Then I should see the item on the shopping cart

  @smoke
  Scenario: As a Customer I can remove a product from shopping cart
    Given I click on add to cart icon
    When I can remove an item from the shopping cart
    Then the product should not appear in the shopping cart
