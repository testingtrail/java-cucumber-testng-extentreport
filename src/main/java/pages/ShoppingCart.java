/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20/19
 Description: Page object to handle locators and methods for ShoppingCart
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

public class ShoppingCart {

    private WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    //icon for shopping cart
    @FindBy(how = How.XPATH, using = "//span[@class='si si-cart']")
    private WebElement btnShopping;

    //button to remove from cart
    @FindBy(how = How.XPATH, using = "//a[@title='Supprimer']")
    private WebElement btnRemove;

    //label for product in shopping cart
    @FindBy(how = How.XPATH, using = "//a[@class='dark-grey item__box-title text-5']")
    private WebElement lblProduct;

    //div to confirm removal
    @FindBy(how = How.ID, using = "cart-remove-confirm")
    private WebElement divRemove;

    //button to accept removal
    @FindBy(how = How.XPATH, using = "//a[@id='cart-remove-confirm-accept']")
    private WebElement btnAcceptRemove;


    public void ClickIcon() throws InterruptedException {
        btnShopping.click();
    }

    public void ClickRemove() throws InterruptedException {
        btnRemove.click();
    }

    public String CheckProduct() {
        return lblProduct.getText();
    }

    public boolean ElementRemoved() {
        WebDriverWait wait = (new WebDriverWait(driver, 12, 2000));
        ExpectedCondition e = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (divRemove.isDisplayed());
            }
        };
        wait.until(e);
        wait.until(ExpectedConditions.visibilityOf(divRemove));

        if (btnAcceptRemove.isEnabled()) {
            wait.until(ExpectedConditions.visibilityOf(btnAcceptRemove)).click();
            return true;
        } else {
            return false;
        }
    }

}
