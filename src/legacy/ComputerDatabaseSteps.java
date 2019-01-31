/****************************************************************************
 Author: Jorge Quiros
 Last updated: 10-25-2018
 Description: Step definitions for all the scenarios
 ***************************************************************************/


package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import pages.AddPage;
import pages.EditPage;
import pages.HomePage;
import java.util.List;

public class ComputerDatabaseSteps{

    private Hook hook;

    private HomePage homepage;
    private AddPage addpage;
    private EditPage editpage;

    //using dependency injection for Hook
    public ComputerDatabaseSteps(Hook hook) {
        this.hook = hook;
        homepage = new HomePage(hook.driver);
        addpage = new AddPage(hook.driver);
        editpage = new EditPage(hook.driver);
    }

    @Given("^I navigate to the home page$")
    public void iNavigateToTheHomePage() throws Throwable {
        hook.driver.navigate().to("https://www.smartbox.com/fr/nos-smartbox/sejour/y606-3-jours-de-reve-amoure.html");
    }

    @When("^I see Play Sample Application Header Link$")
    public void iSeePlaySampleApplicationHeaderLink() throws Throwable {
        Assert.assertEquals(homepage.GetLinkHeader().substring(0,23),"Play sample application");
    }

    @And("^I enter \"([^\"]*)\" as computer in filter$")
    public void iEnterAsComputerInFilter(String computer) throws Throwable {
       homepage.EnterComputer(computer);
       homepage.ClickButton();
    }

    @Then("^I should see the result in the table for \"([^\"]*)\"$")
    public void iShouldSeeTheResultInTheTableFor(String computer) throws Throwable {
        Assert.assertEquals(homepage.GetComputerInTable(computer),computer);
    }

    @And("^I click on Add New computer button$")
    public void iClickOnAddNewComputerButton() throws Throwable {
        homepage.ClickAdd();
    }

    @Then("^I should see Add new Computer page$")
    public void iShouldSeeAddNewComputerPage() throws Throwable {
        Assert.assertEquals(addpage.GetTextHeader(),"Add a computer");
    }

    @And("^I enter the following values for computer$")
    public void iEnterTheFollowingValuesForComputer(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        addpage.EnterValues(data.get(1));
    }

    @And("^Click on Create this computer$")
    public void clickOnCreateThisComputer() throws Throwable {
        addpage.ClickCreate();
    }

    @And("^click on \"([^\"]*)\" computer link$")
    public void clickOnComputerLink(String computer) throws Throwable {
        homepage.ClickComputerInTable(computer);
    }

    @Then("^I should see Edit Computer page$")
    public void iShouldSeeEditComputerPage() throws Throwable {
        Assert.assertEquals(editpage.GetTextHeader(),"Edit computer");
    }

    @And("^I update the following values for computer$")
    public void iUpdateTheFollowingValuesForComputer(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        editpage.EnterValues(data.get(1));
    }

    @And("^Click on Save this computer$")
    public void clickOnSaveThisComputer() throws Throwable {
        editpage.ClickSave();
    }

    @And("^Click on Delete this computer$")
    public void clickOnDeleteThisComputer() throws Throwable {
        editpage.ClickDelete();
    }

    @Then("^I should not see the result in the table for \"([^\"]*)\"$")
    public void iShouldNotSeeTheResultInTheTableFor(String computer) throws Throwable {
        Assert.assertNotEquals(homepage.GetComputerInTable(computer),computer);
    }
}
