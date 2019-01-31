/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20/19
 Description: Step definitions for handling sub category page
 ***************************************************************************/


package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SubCategory;

public class SubCategoryPage {

    private WebDriver driver;

    private SubCategory subCategory;

    //using dependency injection for Hook
    public SubCategoryPage(Hook hook) {
        this.driver = hook.getDriver();
        subCategory = new SubCategory(driver);
    }

    @When("^Subcategory page product page appears$")
    public void subcategoryPageProductPageAppears() throws Throwable {
        Assert.assertEquals(subCategory.CheckSubCategoryPage().substring(0,20),
                "Week-end en amoureux","Product page does not load");
    }

    @Then("^I should see the filter options$")
    public void iShouldSeeTheFilterOptions() throws Throwable {
        Assert.assertEquals(subCategory.CheckFilter(),
                "FILTRES","Filter options are not appearing");
    }

    @And("^I search on the box filter for Title \"([^\"]*)\"$")
    public void iSearchOnTheBoxFilterForTitle(String title) throws Throwable {
        subCategory.setTxtSearch(title);
    }

    @And("^Click on any Box$")
    public void clickOnAnyBoxProduct() throws Throwable {
        subCategory.ClickonBox();
    }
}
