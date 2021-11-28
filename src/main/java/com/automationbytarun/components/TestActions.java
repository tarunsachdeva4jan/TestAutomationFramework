package com.automationbytarun.components;

import com.automationbytarun.browser.DriverManager;
import com.automationbytarun.properties.PropertiesLoader;
import com.automationbytarun.properties.PropertiesValidator;
import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestActions implements ITestListener {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    // public WebDriver driver;
    public DriverManager driverManager;
    public BaseActions pageActions;

    @BeforeSuite
    public void setUpConfigurations() throws Exception {
        PropertiesLoader.environment = System.getProperty("envName");
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        driverManager = new DriverManager();
    }


    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() throws Exception {
        driverManager.loadDriver();
        //driver = driverManager.getDriver();
        driver.set(driverManager.getDriver());
        pageActions = new BaseActions(driver.get());
        //pageActions = new BaseActions(driver);
        pageActions.launchUrl(PropertiesLoader.appUrl);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() throws Exception {
        driverManager.closeBrowser();
    }

    @AfterSuite
    public void tearDownObjects() throws Exception {
        PropertiesLoader.configProperties = null;
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName(); // ();
    }


    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(getTestMethodName(result), "");
        ExtentTestManager.getTest().setDescription(result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        try {
            String base64 = BaseActions.captureSnapshot(getTestMethodName(result),
                    driver.get());
            ExtentTestManager.getTest().log(LogStatus.PASS,
                    ExtentTestManager.getTest().addBase64ScreenShot(base64));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } catch (Exception e) {

        }
    }

    public void onTestFailure(ITestResult result) {
        try {
            String base64 = BaseActions.captureSnapshot(getTestMethodName(result),
                    driver.get());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
            ExtentTestManager.getTest().log(LogStatus.FAIL,
                    ExtentTestManager.getTest().addBase64ScreenShot(base64));
        } catch (Exception e) {

        }

    }


    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test SKIPPED");
    }

    public void onFinish(ITestContext context) {
        ExtentReporter.getReporter().flush();
    }

}
