/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/18/19
 Description: Class to handle util functions across the solution
 ***************************************************************************/

package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.nio.file.*;
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

    /*************************************************************
     Description: returns a file name given a directory and extension
     Paramaters: download directory as string, file extension as string
     Return: NA
     ***********************************************************/
    public static String getDownloadedDocumentName(String downloadDir, String fileExtension)
    {
        String downloadedFileName = null;
        boolean valid = true;
        boolean found = false;

        //default timeout in seconds
        long timeOut = 40;
        try
        {
            //set the path
            Path downloadFolderPath = Paths.get(downloadDir);
            //create a listener
            WatchService watchService = FileSystems.getDefault().newWatchService();
            // add the listener to the path
            downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
            long startTime = System.currentTimeMillis();
            do
            {
                WatchKey watchKey;
                watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
                long currentTime = (System.currentTimeMillis()-startTime)/1000;
                //check if 40 seconds already passed
                if(currentTime>timeOut)
                {
                    System.out.println("OPTA: Download operation timed out... Expected file was not downloaded");
                    return downloadedFileName;
                }

                for (WatchEvent<?> event : watchKey.pollEvents())
                {
                    WatchEvent.Kind <?> kind = event.kind();
                    if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE))
                    {
                        String fileName = event.context().toString();
                        //Checks if the file created is a PDF
                        if(fileName.endsWith(fileExtension))
                        {
                            downloadedFileName = fileName;
                            found = true;
                            break;
                        }
                    }
                }
                if(found)
                {
                    return downloadedFileName;
                }
                else
                {
                    currentTime = (System.currentTimeMillis()-startTime)/1000;
                    if(currentTime>timeOut)
                    {
                        System.out.println("Failed to download expected file");
                        return downloadedFileName;
                    }
                    valid = watchKey.reset();
                }
            } while (valid);
        }

        catch (InterruptedException e)
        {
            System.out.println("OPTA: Interrupted error - " + e.getMessage());
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            System.out.println("OPTA: Download operation timed out.. Expected file was not downloaded");
        }
        catch (Exception e)
        {
            System.out.println("OPTA: Error occurred - " + e.getMessage());
            e.printStackTrace();
        }
        return downloadedFileName;
    }



    /*************************************************************
     Description: Wait for an element to be changed dinamically for any javascript
     Paramaters: webdriver, the expected value once it changed, the Xpath a xpath
     the time to wait for it to change
     Return: boolean of result
     ***********************************************************/
    public static String checkValueChanged(WebDriver driver, String expectedValue, String path, int waitTime) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String elementValue = (String) js
                .executeScript("return document.evaluate(\""+path+"\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value;");

        while (!(elementValue.equals(expectedValue)) && (waitTime>0)) {
            Thread.sleep(1000);
            waitTime--;
            elementValue = (String) js
                    .executeScript("return document.evaluate(\""+path+"\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value;");
        }
        return elementValue;
    }


}
