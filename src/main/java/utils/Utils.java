/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/18/19
 Description: Class to handle util functions across the solution
 ***************************************************************************/

package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Utils {

     /*************************************************************
     Description: Checks if an element exists using locator
     Paramaters: webdriver, the locator
     Return: boolean
     ***********************************************************/
    public static boolean existsElement (WebDriver driver, By locator){
            try {
                driver.findElement(locator);
            } catch (Exception e) {
               return false;
            }
        return true;
    }
 
    /*************************************************************
     Description: Checks if an element is visible or not, so for instance an element that is in the DOM
        but may be or not present depending on conditions
     Paramaters: webdriver, time in seconds to wait, locator
     Return: element if found, if not returns null
     ***********************************************************/
    public static WebElement visibleOrNot(WebDriver driver, int timeToWait, By locator) {
        WebElement element = null;
        try {
            element = new FluentWait<>(driver).
                    withTimeout(timeToWait, TimeUnit.SECONDS).
                    pollingEvery(1, TimeUnit.SECONDS).
                    ignoring(NotFoundException.class).ignoring(NoSuchElementException.class).
                    until(visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {}
        return element;
    }
 
    /*************************************************************
     Description: Clicks an element using Javascript
     Paramaters: driver, webelement to click
     Return: NA
     ***********************************************************/
    public static void clickElementThroughJavaScript(WebDriver driver, WebElement element){
        //To Click on elements which may not be visible on screen
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
 
     /*************************************************************
     Description: Attach an screenshot, with allure attachment tag if needed in future
     Paramaters: webdriver
     Return: NA
     ***********************************************************/
    //@Attachment( type = "image/png")
    public static  byte[] screenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
