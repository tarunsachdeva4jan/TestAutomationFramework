package com.automationbytarun.browser;

import com.automationbytarun.properties.PropertiesLoader;
import com.automationbytarun.properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static WebDriver driver;

    public WebDriver getDriver() {

        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void loadDriver() {
        Browser browser = null;
        String path = "";
        if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Chrome")) {
            browser = new Chrome();//runtime polymorphism
            path = PropertiesLoader.chromeDriverPath;
        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Edge")) {
            browser = new Edge();
            path = PropertiesLoader.edgeDriverPath;
        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Firefox")) {
            browser = new Firefox();
            path = PropertiesLoader.firefoxDriverPath;
        }
        browser.setHeadless(PropertiesLoader.headless);
        browser.setRemote(PropertiesLoader.remoteRun);
        browser.setMaximized(PropertiesLoader.maximizedMode);
        browser.setPageLoadTimeOut(PropertiesLoader.pageLoadWaitTime);
        browser.setPreferences();
        WebDriver driver = browser.loadBrowser(path);
        setDriver(driver);
    }

    public void closeBrowser() {
        driver.close();
    }

    public void closeAllBrowsers() {
        driver.quit();
    }
}
