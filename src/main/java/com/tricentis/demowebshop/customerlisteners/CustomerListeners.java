package com.tricentis.demowebshop.customerlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tricentis.demowebshop.utilities.Utility;
import org.testng.*;

import static com.tricentis.demowebshop.utilities.Utility.takeScreenShot;

public class CustomerListeners implements ITestListener {

    public ExtentSparkReporter reporter;
    public ExtentReports reports;
    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = reports.createTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, "TEST CASE PASSED IS " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
            // This step take screenshot and store in to test-output/html folder
            String screenshotName = Utility.takeScreenShot(result.getName());
            //This line Required for  ReportNG reports
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            // Attach the Screenshot
            Reporter.log("Click to see screenshot");
            Reporter.log("<a target = \"_blank\" href=" + screenshotName + ">Screenshot</a>");
            Reporter.log("<br>");
            Reporter.log("<br>");
            Reporter.log("<a target = \"_blank\" href=" + screenshotName + "><img src=" + screenshotName + " height=200 width=200></img></a>");
        }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(Status.SKIP, "TEST SKIPPED IS " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extent.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Nop Commerce");
        reporter.config().setTheme(Theme.DARK);
        reports = new ExtentReports();
        reports.attachReporter(reporter);

        reports.setSystemInfo("User Name", System.getProperty("user.name"));
        reports.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        reports.setSystemInfo("Machine", "Windows 11" + "64 Bit");
        reports.setSystemInfo("Selenium", "4.21.0");
        reports.setSystemInfo("Maven", "3.8.0");
        reports.setSystemInfo("Java Version", "17");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        reports.flush();
    }

}
