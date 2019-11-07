/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20/19
 Description: Step definitions for handling home page
 ***************************************************************************/


package steps;

import base.DriverHandler;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Home;

import java.text.Normalizer;

public class MainPage {

    private Home homepage;
    private WebDriver driver;

    //using dependency injection for Hook
    public MainPage(Hook hook) {
        this.driver = hook.getDriver();
        homepage = new Home(driver);
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.navigate().to("https://www.smartbox.com/fr/");
        //Check the first time for cookies overlay
        homepage.CheckHomePage();
    }

    @When("^I look for specific product \"([^\"]*)\" in search box$")
    public void iLookForSpecificProductInSearchBox(String searchcriteria) throws Throwable {
        homepage.setEnterText(searchcriteria);
    }

    @Then("^I should see suggestion for my search$")
    public void iShouldSeeSuggestionForMySearch() throws Throwable {
        Assert.assertEquals(Normalizer.normalize(homepage.getSuggestions().substring(0,11),Normalizer.Form.NFD)
                , Normalizer.normalize("Bistrots Et", Normalizer.Form.NFD));
    }

    @Given("^I look for an specific product in the menu$")
    public void iLookForAnSpecificProductInTheMenu() throws Throwable {
        homepage.LookForSubitem();
    }

}