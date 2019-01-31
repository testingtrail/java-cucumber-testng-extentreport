/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20/19
 Description: Step definitions for handling product page
 ***************************************************************************/


package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Product;

public class ProductPage {

    private WebDriver driver;

    private Product product;

    //using dependency injection for Hook
    public ProductPage(Hook hook) {
        this.driver = hook.getDriver();
        product = new Product(driver);
    }

    @Then("^I click on Ajouter au panier$")
    public void iClickOnAjouterAuPanier() throws Throwable {
       product.ClickAddToCart();
    }

    @And("^options Continuer mes Achats, Voir le Panier and Vider le Panier appears on the add to cart overlay$")
    public void optionsContinuerMesAchatsVoirLePanierAndViderLePanierAppearsOnTheAddToCartOverlay() throws Throwable {
        product.CheckOverlayElements();
    }

    @Then("^I click on voir le panier button$")
    public void iClickOnVoirLePanierButton() throws Throwable {
        product.ClickOverlay();
    }

    @Then("^A link for review section should appear$")
    public void aLinkForReviewSectionShouldAppear() throws Throwable {
        Assert.assertEquals(product.CheckReview().substring(5,9), "avis","reviews link not appearing");
    }
}
