package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private static final String CSS_FORM_CART = "#content form";
    private static final String CSS_BUTTON_UPDATE = "input.btn-success";

    public CartPage() {

    }

    public boolean checkCartPageDisplay() {
        return actionUtility.checkElementDisplay(By.cssSelector(CSS_FORM_CART), 10);
    }

    public boolean checkProductDisplay(String name, String price) {
        return actionUtility.checkElementDisplay(By.xpath("//section[@class='cart item row'][.//section[contains(string(),'" + name + "')]][.//section[contains(text(),'" + price + "')]]"), 10);
    }

    public void changeSizeAndQtyProduct(String name, String price, String size, String qty) {
        waitUtility.waitUntilVisibility(By.xpath("//section[@class='cart item row'][.//section[contains(string(),'" + name + "')]][.//section[contains(text(),'" + price.replace(",", ".") + "')]]//input[contains(@name,'size')]"));

        driver.findElement(By.xpath("//section[@class='cart item row'][.//section[contains(string(),'" + name + "')]][.//section[contains(text(),'" + price.replace(",", ".") + "')]]//input[contains(@name,'size')]")).clear();
        driver.findElement(By.xpath("//section[@class='cart item row'][.//section[contains(string(),'" + name + "')]][.//section[contains(text(),'" + price.replace(",", ".") + "')]]//input[contains(@name,'size')]")).sendKeys(size);
        driver.findElement(By.xpath("//section[@class='cart item row'][.//section[contains(string(),'" + name + "')]][.//section[contains(text(),'" + price.replace(",", ".") + "')]]//input[contains(@name,'number')]")).clear();
        driver.findElement(By.xpath("//section[@class='cart item row'][.//section[contains(string(),'" + name + "')]][.//section[contains(text(),'" + price.replace(",", ".") + "')]]//input[contains(@name,'number')]")).sendKeys(qty);
    }

    public void clickOnUpdateButton() {
        driver.findElement(By.cssSelector(CSS_BUTTON_UPDATE)).click();
        waitUtility.sleep(500);
    }

    public boolean checkProductDisplayWithSizeAndQty(String name, String price, String size, String qty) {
        return actionUtility.checkElementDisplay(By.xpath("//section[@class='cart item row'][.//section[contains(string(),'" + name + "')]][.//section[contains(text(),'" + price.replace(",", ".") + "')]][.//input[contains(@name,'size')][@value='" + size + "']][.//input[contains(@name,'number')][@value='" + qty + "']]"), 10);
    }

}

