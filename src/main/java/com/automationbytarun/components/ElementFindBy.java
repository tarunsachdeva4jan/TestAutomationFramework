package com.automationbytarun.components;

import com.automationbytarun.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ElementFindBy {

    WebDriver driver;

    public ElementFindBy(WebDriver driver) {
        this.driver = driver;
    }

    public By findBy(String element) throws IOException, Exception {
        By by;
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadProperties();
        String elementValue = loader.getProperty(element);
        String findBy = elementValue.split(":")[0];
        String findByValue = elementValue.split(":")[1];
        if (findBy.equalsIgnoreCase("xpath")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("id")) {
            by = By.id(findByValue);
        } else if (findBy.equalsIgnoreCase("name")) {
            by = By.name(findByValue);
        } else if (findBy.equalsIgnoreCase("class")) {
            by = By.className(findByValue);
        } else if (findBy.equalsIgnoreCase("css")) {
            by = By.cssSelector(findByValue);
        } else if (findBy.equalsIgnoreCase("linkText")) {
            by = By.linkText(findByValue);
        } else if (findBy.equalsIgnoreCase("partialLinktext")) {
            by = By.partialLinkText(findByValue);
        } else {
            throw new Exception("Invalid Locator Type/Value in [" + element + "]. Pls check value in OR file");
        }
        return by;
    }

    public WebElement findElementBy(String element) throws Exception {
        By by = findBy(element);
        return driver.findElement(by);
    }


}
