package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtility {
    private WebDriver driver;
    private JavascriptExecutor js;
    Actions actions;
    WaitUtility waitUtility;

    public ActionUtility(WebDriver driver) {
        this.driver = driver;
        initComponents();
    }

    private void initComponents() {
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        waitUtility = new WaitUtility(driver);
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void clickByJS(WebElement ele) {
        js.executeScript("arguments[0].click();", ele);
    }

    public boolean checkElementDisplay(By by, long timeout) {
        try {
            waitUtility.waitUntilVisibility(by, timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkElementExist(By by, long waitingTime) {
        try {
            waitUtility.waitUntilPresent(by, waitingTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkElementNotExist(By by, long waitingTime) {
        try {
            waitUtility.waitUntilElementNotExist(by, (int) waitingTime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getHTML5ValidationMessage(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

    public void scrollToElement(By by) {
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(by));
        waitUtility.sleep(200);
    }

    public boolean isAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException eTO) {
        }
        return false;
    }

    public int getPrice(String data) {
        try {
            return Integer.valueOf(data.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
