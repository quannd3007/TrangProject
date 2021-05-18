package hooks;

import driver.CustomSeleniumDriver;
import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StepHelper {

    public void saveScreenshot() {
        try {
            Allure.getLifecycle().addAttachment("Page Screenshot", "image/png", "png", ((CustomSeleniumDriver) DriverFactory.getDriver()).takeScreenShot());
        } catch (Exception e) {
            try {
                Allure.getLifecycle().addAttachment("Page Screenshot", "image/png", "png", ((CustomSeleniumDriver) DriverFactory.getDriver()).screenShot());
            } catch (Exception ex) {
            }
        }
    }

}
