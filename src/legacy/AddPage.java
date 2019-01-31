/****************************************************************************
 Author: Jorge Quiros
 Last updated: 10-24-2018
 Description: Page object to handle locators and methods for Add computer
 ***************************************************************************/

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddPage {

    public AddPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    //Add header text
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/h1")
    public WebElement capHeader;

    //Create this computer button
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/form/div/input")
    public WebElement btnCreate;

    //name field
    @FindBy(how = How.ID, using = "name")
    public WebElement txtName;

    //introduced field
    @FindBy(how = How.ID, using = "introduced")
    public WebElement txtIntroduced;

    //discontinued field
    @FindBy(how = How.ID, using = "discontinued")
    public WebElement txtDiscontinued;

    //company dropdown
    @FindBy(how = How.ID, using = "company")
    public WebElement dropCompany;

    public String GetTextHeader(){
        return capHeader.getText();
    }

    public void EnterValues(List<String> values){
        txtName.sendKeys(values.get(0));
        txtIntroduced.sendKeys(values.get(1));
        txtDiscontinued.sendKeys(values.get(2));

        Select dropdown= new Select(dropCompany);
        dropdown.selectByVisibleText(values.get(3));
    }

    public void ClickCreate(){
        btnCreate.submit();
    }

}
