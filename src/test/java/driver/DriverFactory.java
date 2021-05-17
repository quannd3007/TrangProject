package driver;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void setDriver(WebDriver driver) {
        drivers.set(driver);
    }

    public static void quitDriver() {
        drivers.get().quit();
        drivers.remove();
    }
}
