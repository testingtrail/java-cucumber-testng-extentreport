/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/17/19
 Description: Initialize the driver, using Singleton pattern to have just one
              instance of the driver
 ***************************************************************************/

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverHandler {
    private WebDriver driver;
    private static DriverHandler _driverHandler;


    private DriverHandler() {
        String driverpath = new File("").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverpath + "\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
