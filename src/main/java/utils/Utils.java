/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/18/19
 Description: Class to handle util functions across the solution
 ***************************************************************************/

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utils {

    public static boolean existsElement (WebDriver driver, By locator){
            try {
                driver.findElement(locator);
            } catch (Exception e) {
               return false;
            }
        return true;
    }

}
