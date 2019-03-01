/****************************************************************************
 Author: Jorge Quiros
 Last updated: 02/28/19
 Description: Adding extent report methods to some of the listeners
 ***************************************************************************/

package runner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ngTestListener implements ITestListener {

    //ExtentReportUtil extentReportUtil = new ExtentReportUtil();

    //All of these methods appear when adding implements ITestListener, then alt+enter, then implement methods.
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On test start");


        //set up the report
       // ExtentReportUtil.GetInstanceExtentReportUtil().createExtentReportUtil();

        //ToDo: feature - hardcoding the feature name
       // ExtentReportUtil.GetInstanceExtentReportUtil().setFeatures(ExtentReportUtil.GetInstanceExtentReportUtil().getExtend().createTest(Feature.class, "Boxes Display Feature"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On test failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("On test success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On finish");

        //Flush the extent report
       // ExtentReportUtil.GetInstanceExtentReportUtil().FlushReport();
    }
}
