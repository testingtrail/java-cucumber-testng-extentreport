/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20/19
 Description: Step definitions for handling shopping cart page
 ***************************************************************************/


package steps;

import cucumber.api.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ShoppingCart;

public class ShoppingCartPage {

    private WebDriver driver;

    private ShoppingCart shoppingcart;

    //using dependency injection for Hook
    public ShoppingCartPage(Hook hook) {
        this.driver = hook.getDriver();
        shoppingcart = new ShoppingCart(driver);
    }

    @Given("^I click on add to cart icon$")
    public void iClickOnAddToCartIcon() throws Throwable {
        shoppingcart.ClickIcon();
    }

    @When("^I can remove an item from the shopping cart$")
    public void iCanRemoveAnItemFromTheShoppingCart() throws Throwable {
        shoppingcart.ClickRemove();
    }

    @Then("^I should see the item on the shopping cart$")
    public void iShouldSeeTheItemOnTheShoppingCart() throws Throwable {
        Assert.assertEquals(shoppingcart.CheckProduct().substring(0,7),"3 jours");
    }

    @Then("^the product should not appear in the shopping cart$")
    public void theProductShouldNotAppearInTheShoppingCart() throws Throwable {

        boolean removed = true;
        if(!shoppingcart.ElementRemoved()) {
            removed = false;
        }
        Assert.assertEquals(removed,true,"Item was not removed from shopping cart");
    }



}
