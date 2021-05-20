package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private static final String CSS_FORM_CART = "#content form";
    private static final String CSS_BUTTON_UPDATE = "input.btn-success";
    private static final String CSS_BUTTON_DELETE_ALL = "a.btn.btn-danger";
    private static final String CSS_BUTTON_CHECKOUT = "a.btn.btn-warning";
    private static final String XPATH_MESSAGE_EMPTY_CART = "//section[contains(text(),'Giỏ hàng trống')]";
    private static final String XPATH_MESSAGE_DELETE_ALL_ITEMS = "//section[contains(text(),'Bạn đã xóa tất cả sản phẩm trong giỏ!')]";

    private static final String XPATH_PRODUCT = "//section[@class='cart item row'][.//section[contains(string(),'%s')]][.//section[contains(text(),'%s')]]";
    private static final String XPATH_PRODUCT_WITH_SIZE_QTY = "//section[@class='cart item row'][.//section[contains(string(),'%s')]][.//section[contains(text(),'%s')]][.//input[contains(@name,'size')][@value='%s']][.//input[contains(@name,'number')][@value='%s']]";
    private static final String XPATH_PRODUCT_SIZE = "//section[@class='cart item row'][.//section[contains(string(),'%s')]][.//section[contains(text(),'%s')]]//input[contains(@name,'size')]";
    private static final String XPATH_PRODUCT_QUANTITY = "//section[@class='cart item row'][.//section[contains(string(),'%s')]][.//section[contains(text(),'%s')]]//input[contains(@name,'number')]";
    private static final String XPATH_ICON_DELETE_PRODUCT = "//section[@class='cart item row'][.//section[contains(string(),'%s')]][.//section[contains(text(),'%s')]]//a";

    public CartPage() {

    }

    public boolean checkCartPageDisplay() {
        return actionUtility.checkElementDisplay(By.cssSelector(CSS_FORM_CART), 10);
    }

    public boolean checkProductDisplay(String name, String price) {
        return actionUtility.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT, name, price.replace(",", "."))), 10);
    }

    public void changeSizeAndQtyProduct(String name, String price, String size, String qty) {
        waitUtility.waitUntilVisibility(By.xpath(String.format(XPATH_PRODUCT_SIZE, name, price.replace(",", "."))));

        driver.findElement(By.xpath(String.format(XPATH_PRODUCT_SIZE, name, price.replace(",", ".")))).clear();
        driver.findElement(By.xpath(String.format(XPATH_PRODUCT_SIZE, name, price.replace(",", ".")))).sendKeys(size);
        driver.findElement(By.xpath(String.format(XPATH_PRODUCT_QUANTITY, name, price.replace(",", ".")))).clear();
        driver.findElement(By.xpath(String.format(XPATH_PRODUCT_QUANTITY, name, price.replace(",", ".")))).sendKeys(qty);
    }

    public void clickOnUpdateButton() {
        driver.findElement(By.cssSelector(CSS_BUTTON_UPDATE)).click();
        waitUtility.sleep(500);
    }

    public boolean checkProductDisplayWithSizeAndQty(String name, String price, String size, String qty) {
        return actionUtility.checkElementDisplay(By.xpath(String.format(XPATH_PRODUCT_WITH_SIZE_QTY, name, price.replace(",", "."), size, qty)), 10);
    }

    public void clickOnDeleteIconOfProduct(String name, String price) {
        waitUtility.waitUntilVisibility(By.xpath(String.format(XPATH_ICON_DELETE_PRODUCT, name, price.replace(",", "."))));
        driver.findElement(By.xpath(String.format(XPATH_ICON_DELETE_PRODUCT, name, price.replace(",", ".")))).click();
    }

    public void clickOnButtonDeleteAll() {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_BUTTON_DELETE_ALL));
        driver.findElement(By.cssSelector(CSS_BUTTON_DELETE_ALL)).click();
    }

    public boolean checkDeletePopupIsDisplayed() {
        return actionUtility.isAlertPresent();
    }

    public void clickOnButtonCancelOnDeletePopup() {
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
    }

    public void clickOnButtonOKOnDeletePopup() {
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public boolean checkTheScreenDisplayedMessageCartEmpty() {
        return actionUtility.checkElementDisplay(By.xpath(XPATH_MESSAGE_EMPTY_CART), 30);
    }

    public void clickOnButtonCheckout() {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_BUTTON_CHECKOUT));
        waitUtility.waitUntilToBeClickAble(By.cssSelector(CSS_BUTTON_CHECKOUT));
        driver.findElement(By.cssSelector(CSS_BUTTON_CHECKOUT)).click();
    }

    public boolean checkMessageDeleteAllItems() {
        return actionUtility.checkElementDisplay(By.xpath(XPATH_MESSAGE_DELETE_ALL_ITEMS), 5);
    }
}

