import com.automationbytarun.browser.DriverManager;
import com.automationbytarun.components.ElementFindBy;
import com.automationbytarun.properties.PropertiesLoader;
import com.automationbytarun.properties.PropertiesValidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SampleTest {


    @Test
    public void loadBrowserTest() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        DriverManager driverManager = new DriverManager();
        driverManager.loadDriver();
        DriverManager.driver.get("http://www.google.com");
        Thread.sleep(3000);
        ElementFindBy findBy = new ElementFindBy(DriverManager.driver);
        WebElement element = findBy.findElementBy("GooglePage.tbx_Search");
        element.sendKeys("Testing Framework");
        Thread.sleep(4000);
        driverManager.closeAllBrowsers();
    }
}
