package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class WaitUtility {

    public static final int TIMEOUT_INTERVAL_UNIT = 60;
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public WaitUtility(WebDriver driver) {
        this.driver = driver;
        initComponents();
    }

    private void initComponents() {
        wait = new WebDriverWait(driver, TIMEOUT_INTERVAL_UNIT);
        wait.pollingEvery(Duration.ofSeconds(5));
        js = ((JavascriptExecutor) driver);
    }

    public void waitUntilPresent(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilPresent(By by, long waitingTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitingTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilVisibility(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitUntilVisibility(WebElement ele, long waitingTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitingTime);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitUntilVisibility(By by, long waitingTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitingTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilToBeClickAble(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilToBeClickAble(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void waitForExpectedValue(By by, String value) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(by, value));
    }

    public void waitForExpectedValue(WebElement ele, String value) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(ele, value));
    }

    public void waitForExpectedText(By by, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    public void waitForTextChange(By by, String text) throws Exception {
        WebElement element = driver.findElement(by);
        waitForTextChange(element, text);
    }

    public void waitUntilElementExist(By by, int endTime) throws Exception {
        int time = 0;

        while (time < endTime) {
            if (driver.findElements(by).size() > 0) {
                return;
            }
            time++;
            sleep(1000);
        }

        throw new Exception("Element does not exist on page!!!");
    }

    public void waitUntilElementNotExist(By by) throws Exception {
        int time = 0;

        while (time < TIMEOUT_INTERVAL_UNIT) {
            if (driver.findElements(by).size() < 1) {
                return;
            }
            time++;
            sleep(1000);
        }

        throw new Exception("Element still exist on page!!!");
    }

    public void waitUntilElementNotExist(By by, int endTime) throws Exception {
        int time = 0;

        while (time < endTime) {
            if (driver.findElements(by).size() < 1) {
                return;
            }
            time++;
            sleep(1000);
        }

        throw new Exception("Element still exist on page!!!");
    }

    public void waitForElementHasText(By by) {
        wait.until(ExpectedConditions.textMatches(by, Pattern.compile("\\s*\\S.*")));
    }

    public void waitForUntilInvisibility(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForValueOfAttribute(WebElement element, String attribute, String expectedValue) throws Exception {
        for (int i = 0; i < TIMEOUT_INTERVAL_UNIT; i++) {
            if (!element.getAttribute(attribute).equals(expectedValue)) {
                sleep(1000);
            } else {
                return;
            }
        }

        throw new Exception("Expected value: " + expectedValue + " but Actual: " + element.getAttribute(attribute));
    }

    public void waitUntilInvisibility(WebElement ele) {
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public void waitUntilInvisibility(By by) {
        wait.until(ExpectedConditions.numberOfElementsToBe(by, 0));
    }

    public void waitForTextChange(WebElement element, String text) throws Exception {
        for (int i = 0; i < TIMEOUT_INTERVAL_UNIT; i++) {
            if (element.getText().equals(text))
                sleep(1000);
            else
                return;
        }

        throw new Exception("Expected value: " + text + " but Actual: " + element.getText());
    }

    public void waitForPageLoad() {
        try {
            waitForJQueryLoad();
            waitUntilJSReady();
        } catch (Throwable error) {
        }
    }

    public void stopPageLoad() {
        js.executeScript("window.stop();");
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Wait Until JS Ready
    public void waitUntilJSReady() {
        int counting = 1;
        String pageLoadStatus;
        do {
            sleep(1000);
            pageLoadStatus = (String) js.executeScript("return document.readyState");
            counting++;
        } while (!pageLoadStatus.contains("complete") && (counting < TIMEOUT_INTERVAL_UNIT));
    }

    //Wait for JQuery Load
    public void waitForJQueryLoad() {

        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        int counting = 1;
        final String jQueryActiveScript = "return window.jQuery != undefined && jQuery.active==0";

        //Get JQuery is Ready
        boolean jqueryReady;
        //Wait JQuery until it is Ready!
        do {
            sleep(1000);
            jqueryReady = (Boolean) jsExec.executeScript(jQueryActiveScript);
            counting++;
        } while (!jqueryReady && (counting < TIMEOUT_INTERVAL_UNIT));

    }
}
