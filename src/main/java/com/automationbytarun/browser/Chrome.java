package com.automationbytarun.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Chrome extends Browser {

    ChromeOptions chromeOptions;

    @Override
    public void setPreferences() {
        chromeOptions = new ChromeOptions();

        if (isHeadless()) {
            chromeOptions.setHeadless(true);
        }

        if (isMaximized()) {
            chromeOptions.addArguments("start-maximized");
        }
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("useAutomationExtension", false);
        prefs.put("excludeSwitches",
                Collections.singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("prefs", prefs);

    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", path);
        if (isRemote()) {
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeOut(), TimeUnit.SECONDS);
            if (isDeleteCookies()) {
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
