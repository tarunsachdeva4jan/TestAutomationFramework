package com.automationbytarun.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox extends Browser {

    FirefoxOptions firefoxOptions;

    @Override
    public void setPreferences() {

    }

    @Override
    public WebDriver loadBrowser(String path) {
        return null;
    }
}
