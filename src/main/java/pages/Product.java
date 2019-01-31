/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20/19
 Description: Page object to handle locators and methods for Product or box  page
 ***************************************************************************/

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Product {

    private WebDriver driver;

    public Product(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    //button in product page to add to cart
    @FindBy(how = How.XPATH, using = "//div[@class='clearfix']//span[@class='add-to-cart__content']")
    private WebElement btnAdd;

    //div overlay for confirmation to add to cart
    @FindBy(how = How.ID, using = "addtocart-confirmation")
    private WebElement divCar;

    //continue shopping button
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/a[1]")
    private WebElement btnContinueShopping;

    //add to cart button
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/a[2]")
    private WebElement btnAddCart;

    //link to review comments
    @FindBy(how = How.XPATH, using = "//div[1]/div[2]/a/span/span[contains(text(),'avis')]")
    private WebElement linkReview;


    public void ClickAddToCart() throws InterruptedException {
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (btnAdd.isEnabled());
            }
        };
        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(e);

        btnAdd.click();
    }

    public void CheckOverlayElements() {
        boolean flag = true;
        WebDriverWait wait = (new WebDriverWait(driver, 10, 2000));
        wait.until(ExpectedConditions.visibilityOf(btnContinueShopping));
        if(!btnContinueShopping.isDisplayed())
            flag = false;
        wait.until(ExpectedConditions.visibilityOf(btnAddCart));
        if(!btnAddCart.isDisplayed())
            flag = false;
        Assert.assertEquals(flag,true);
    }

    public void ClickOverlay(){
        btnAddCart.click();
    }

    public String CheckReview(){
        return linkReview.getText();
    }


}
