package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class OrderPage extends BasePage {

    private static final String NAME_FULL_NAME = "fullName";
    private static final String NAME_MOBILE = "mobile";
    private static final String NAME_EMAIL = "email";
    private static final String NAME_ADDRESS = "address";
    private static final String NAME_RECEIVER = "receiver";
    private static final String NAME_RECEIVER_MOBILE = "receiverMobile";
    private static final String NAME_RECEIVER_ADDRESS = "receiverAddress";

    private static final String CSS_BUTTON_SUBMIT = "button.btn.btn-info";
    private static final String CSS_BUTTON_PLACE_ORDER = "input.btn.btn-success";
    private static final String XPATH_PAYMENT_METHOD = "//section[contains(string(),'%s')]/input";

    public OrderPage() {
    }

    public void deleteAllField() {
        waitUtility.waitUntilVisibility(By.name(NAME_FULL_NAME));

        driver.findElement(By.name(NAME_FULL_NAME)).clear();
        driver.findElement(By.name(NAME_MOBILE)).clear();
        driver.findElement(By.name(NAME_EMAIL)).clear();
        driver.findElement(By.name(NAME_ADDRESS)).clear();
        driver.findElement(By.name(NAME_RECEIVER)).clear();
        driver.findElement(By.name(NAME_RECEIVER_MOBILE)).clear();
        driver.findElement(By.name(NAME_RECEIVER_ADDRESS)).clear();
    }

    public void clickOnButtonSubmit() {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_BUTTON_SUBMIT));
        driver.findElement(By.cssSelector(CSS_BUTTON_SUBMIT)).click();
    }

    public boolean checkMessageRequiredFiledDisplay() {
        return actionUtility.checkElementDisplay(By.id("requiredFiledMessage"), 10);
    }

    public String getValueOfField(By by) {
        waitUtility.waitUntilVisibility(by);
        return driver.findElement(by).getAttribute("value");
    }

    public String getFullName() {
        return getValueOfField(By.name(NAME_FULL_NAME));
    }

    public String getMobile() {
        return getValueOfField(By.name(NAME_MOBILE));
    }

    public String getEmail() {
        return getValueOfField(By.name(NAME_EMAIL));
    }

    public String getAddress() {
        return getValueOfField(By.name(NAME_ADDRESS));
    }

    public String getReceiver() {
        return getValueOfField(By.name(NAME_RECEIVER));
    }

    public String getReceiverMobile() {
        return getValueOfField(By.name(NAME_RECEIVER_MOBILE));
    }

    public String getReceiverAddress() {
        return getValueOfField(By.name(NAME_RECEIVER_ADDRESS));
    }

    public void updateValueOfField(By by, String value) {
        waitUtility.waitUntilVisibility(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(value);
    }

    public void updateReceiver(String value) {
        updateValueOfField(By.name(NAME_RECEIVER), value);
    }

    public void updateReceiverMobile(String value) {
        updateValueOfField(By.name(NAME_RECEIVER_MOBILE), value);
    }

    public void updateReceiverAddress(String value) {
        updateValueOfField(By.name(NAME_RECEIVER_ADDRESS), value);
    }

    public void selectPaymentMethodAs(String method) {
        waitUtility.waitUntilVisibility(By.xpath(String.format(XPATH_PAYMENT_METHOD, method)));
        driver.findElement(By.xpath(String.format(XPATH_PAYMENT_METHOD, method))).click();
    }

    public boolean checkPaymentMethodSelected(String method) {
        return driver.findElement(By.xpath(String.format(XPATH_PAYMENT_METHOD, method))).isSelected();
    }

    public void clickOnButtonPlaceOrder() {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_BUTTON_PLACE_ORDER));
        waitUtility.waitUntilToBeClickAble(By.cssSelector(CSS_BUTTON_PLACE_ORDER));
        driver.findElement(By.cssSelector(CSS_BUTTON_PLACE_ORDER)).click();
    }

    public boolean checkPlaceOrderSuccessPopupIsDisplayed() {
        return actionUtility.isAlertPresent();
    }

    public String getPlaceOrderSuccessMessage() {
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        driver.switchTo().defaultContent();
        return message;
    }

}
