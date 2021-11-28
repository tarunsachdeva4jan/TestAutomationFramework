package com.automationbytarun.properties;


import com.automationbytarun.ConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties configProperties;
    public static String extentReportPath;
    public static String runOnBrowser;
    public static Boolean takeScreenshot;
    public static String chromeDriverPath;
    public static String ieDriverPath;
    public static String edgeDriverPath;
    public static String firefoxDriverPath;
    public static Boolean maximizedMode;
    public static Integer implicitWaitTime;
    public static Integer explicitWaitTime;
    public static Integer pageLoadWaitTime;
    public static boolean headless;
    public static boolean deleteCookies;
    public static boolean remoteRun;
    public static String appUrl;
    public static String environment;

    public static void initializeProperties() throws Exception {
        if (configProperties == null) {
            configProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//resources//config-" + PropertiesLoader.environment + ".properties"));
            System.out.println("Environment Initialized: " + environment);
            configProperties.load(fileInputStream);
        }
        runOnBrowser = configProperties.getProperty("RunOnBrowser");
        takeScreenshot = Boolean.valueOf(configProperties.getProperty("TakeScreenshot"));
        chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
        ieDriverPath = configProperties.getProperty("IEDriverPath");
        edgeDriverPath = configProperties.getProperty("EdgeDriverPath");
        firefoxDriverPath = configProperties.getProperty("FirefoxDriverPath");
        maximizedMode = Boolean.valueOf(configProperties.getProperty("MaximizedMode"));
        implicitWaitTime = Integer.valueOf(configProperties.getProperty("ImplicitWait"));
        explicitWaitTime = Integer.valueOf(configProperties.getProperty("ExplicitWait"));
        pageLoadWaitTime = Integer.valueOf(configProperties.getProperty("PageLoadWait"));
        headless = Boolean.valueOf(configProperties.getProperty("headless"));
        deleteCookies = Boolean.valueOf(configProperties.getProperty("deleteCookies"));
        remoteRun = Boolean.valueOf(configProperties.getProperty("remoteRun"));
        appUrl = configProperties.getProperty("appUrl");
        if (environment.isEmpty())
            environment = "stg";

    }


    public static void main(String[] args) throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
    }

}
