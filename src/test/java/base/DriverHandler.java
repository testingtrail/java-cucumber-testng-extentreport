/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/17/19
 Description: Initialize the driver, using Singleton pattern to have just one
              instance of the driver
 ***************************************************************************/

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverHandler {
    private WebDriver driver;
    private static DriverHandler _driverHandler;


    private DriverHandler() {
        //String driverpath = new File("").getAbsolutePath();
        ChromeOptions options = new ChromeOptions();
        // disable notifications popup
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        //something is happening that the next like is throwing an error
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    //Here is where the singleton pattern is applied, if the instance is null then call constructor
    // if not, return the instance
    public static DriverHandler GetInstanceDriverHandler(){
        if (null == _driverHandler)
            _driverHandler = new DriverHandler();
        return _driverHandler;
    }

    // Get the driver
    public WebDriver getDriver() {
        return driver;
    }

    // Close the driver
    public void TearDown() {
        driver.close();
        driver.quit();
    }

}
