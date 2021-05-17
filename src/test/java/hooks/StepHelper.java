package hooks;

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
            Allure.getLifecycle().addAttachment("Page Screenshot", "image/png", "png", ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES));
        } catch (Exception e) {
            try {
                Allure.getLifecycle().addAttachment("Page Screenshot", "image/png", "png", ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES));
            } catch (Exception ex) {
            }
        }
    }

}
