package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class SharedDriver {

    public SharedDriver() {
    }

    public void initialize() throws Exception {
        if (DriverFactory.getDriver() == null) {

            WebDriver driver;

            String browser = "chrome";

            if (System.getProperty("browser") != null) {

                switch (browser) {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();

                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--width=1920");
                        firefoxOptions.addArguments("--height=1080");

                        driver = new FirefoxDriver(firefoxOptions);

                        break;

                    default:

                        WebDriverManager.chromedriver().setup();

                        ChromeOptions option = new ChromeOptions();
                        option.addArguments("--window-size=1920,1080");

                        driver = new ChromeDriver(option);

                        break;
                }

            } else {
                WebDriverManager.chromedriver().setup();

                ChromeOptions option = new ChromeOptions();
                option.addArguments("--window-size=1920,1080");

                driver = new CustomChromeDriver(option);
            }

            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
            DriverFactory.setDriver(driver);
        }
    }
}
