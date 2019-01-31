/****************************************************************************
 Author: Jorge Quiros
 Last updated: 10-25-2018
 Description: Page object to handle locators and methods for Edit computer
 ***************************************************************************/

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EditPage {

    public EditPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    //Edit header text
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/h1")
    public WebElement capHeader;

    //Save this computer button
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/form[1]/div/input")
    public WebElement btnSave;

    //Delete this computer button
    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/form[2]/input")
    public WebElement btnDelete;

    //name field
    @FindBy(how = How.ID, using = "name")
    public WebElement txtName;

    //introduced field
    @FindBy(how = How.ID, using = "introduced")
    public WebElement txtIntroduced;


    //company dropdown
    @FindBy(how = How.ID, using = "company")
    public WebElement dropCompany;

    public String GetTextHeader(){
        return capHeader.getText();
    }

    public void EnterValues(List<String> values){
        txtName.clear();
        txtName.sendKeys(values.get(0));

        txtIntroduced.clear();
        txtIntroduced.sendKeys(values.get(1));


        Select dropdown= new Select(dropCompany);
        dropdown.selectByVisibleText(values.get(2));
    }

    public void ClickSave(){
        btnSave.submit();
    }

    public void ClickDelete(){
        btnDelete.submit();
    }

}
