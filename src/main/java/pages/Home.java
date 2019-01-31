/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20/19
 Description: Page object to handle locators and methods for Home page
 ***************************************************************************/

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

public class Home {

    private WebDriver driver;

    public Home(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    //Link to accept cookies
    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Accepter")
    private WebElement linkCookies;

    //search box
    @FindBy(how = How.NAME, using = "text")
    private WebElement txtSearch;

    //Suggestion for search box
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/header[1]/div[1]/section[1]/section[2]/section[2]/div[1]/form[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
    private WebElement lblSuggestion;

    //div with suggestion
    @FindBy(how = How.XPATH, using = "//form[@id='search']//ul[@class='autocomplete-results has-results']")
    private WebElement divSuggestion;

    //menu item
    @FindBy(how = How.XPATH, using = "//nav[1]/ul[@id='aut-header-menu']/li[1]/a[1]")
    private WebElement lblmenu;

    //submenu item
    @FindBy(how = How.XPATH, using = "//nav[1]/ul[@id='aut-header-menu']/li[1]/ul/li[2]/a[1]")
    private WebElement lblsubmenu;

    public void CheckHomePage() throws InterruptedException {
        By locator = By.partialLinkText("Accepter");

        Boolean isPresent = Utils.existsElement( driver, locator);
        if(isPresent) {
            ExpectedCondition e = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return (linkCookies.getSize().height > 10);
                }
            };
            WebDriverWait wait = (new WebDriverWait(driver, 10));
            wait.until(e);
            linkCookies.click();
        }
    }

    public void setEnterText(String searchcriteria){
        txtSearch.sendKeys(searchcriteria);
    }

    public String getSuggestions() {
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.elementToBeClickable(divSuggestion));

        return lblSuggestion.getText();
    }

    public void LookForSubitem() {
        Actions action  = new Actions(driver);
        action.moveToElement(lblmenu).clickAndHold(lblmenu).perform();

        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.elementToBeClickable(lblsubmenu));

        lblsubmenu.click();

    }



}
