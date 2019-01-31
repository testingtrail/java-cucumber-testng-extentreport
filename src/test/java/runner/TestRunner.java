package runner;
/****************************************************************************
 Author: Jorge Quiros
 Last updated: 01/20.19
 Description: Class to create glue between Feature File and TestNG to run
              cucumber via Maven
 ***************************************************************************/

import base.DriverHandler;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"steps"},
        //~ will skip the features with that specific tag
        tags = {"@smoke","~@skipped_temporal"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests{

    //Added  TestNG annotation to allow closing the browser at the end
    @AfterSuite
    public static void tearDown(){ DriverHandler.GetInstanceDriverHandler().TearDown();
    }
}

//Strict : it will try to find the pending steps or missing steps, and fail if not find
//features :need to provide path of feature
//format : will contain the reporting features
//tag : for tagged hookes for scenarios
//monochrome : enhance the readbility
//glue : provide your stepdefinition class path
//dryrun : will check if u have pending or missing steps, but will not fail scripts