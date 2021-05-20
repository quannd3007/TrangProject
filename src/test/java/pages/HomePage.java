package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends BasePage {

    private static final String CSS_LOGIN_BUTTON = "#nav1 a[href*='login']";
    private static final String XPATH_USERNAME = "//button[contains(string(),'%s')]";
    private static final String CSS_INPUT_SEARCH = "input.form-control.mr-2";
    private static final String CSS_LIST_PRODUCT_DISPLAY = "aside.main section.row section.product";
    private static final String XPATH_BUTTON_MY_CART = "//nav[@id='nav1']//a[@class='nav-link'][contains(@href,'cart')]";

    private static final String XPATH_LIST_PRODUCT = "//section[@class='row']/section[contains(@class,'product')]";
    private static final String XPATH_PRODUCT_NAME_INDEX = "//section[@class='row']/section[contains(@class,'product')][%s]//section[@class='productName']";
    private static final String XPATH_PAGINATION = "//ul[@class='pagination']/li";
    private static final String XPATH_ICON_NEXT_PAGE_DISABLE = "//ul[@class='pagination']/li[last()][not(contains(@class,'disabled'))]";
    private static final String XPATH_ICON_NEXT_PAGE_NOT_DISABLE = "//ul[@class='pagination']/li[last()]";
    private static final String XPATH_BUTTON_ADD_TO_CART_OF_PRODUCT = "//section[@class='row']/section[contains(@class,'product')][.//section[@class='productName'][contains(text(),'%s')]][.//section[@class='price'][contains(text(),'%s')]][1]//a[contains(@class,'btn-outline-info')]";


    private static final String XPATH_MENU_BRANCH = "//nav[@id='nav1']//a[text()='%s']";
    private static final String XPATH_LEFT_PRICE = "//aside[contains(@class,'left')]//a[contains(string(),'%s')]";
    private static final String XPATH_PRODUCT_PRICE_INDEX = "//section[@class='row']/section[contains(@class,'product')][%s]//section[@class='price']";
    private static final String XPATH_PRODUCT_PRICE_INDEX_OLD = "//section[@class='row']/section[contains(@class,'product')][%s]//section[@class='price'][1]";
    private static final String XPATH_PRODUCT_PRICE_INDEX_DISCOUNT = "//section[@class='row']/section[contains(@class,'product')][%s]//section[@class='price'][2]";

    public HomePage() {
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector(CSS_LOGIN_BUTTON)).click();
    }

    public void clickMyCartButton() {
        waitUtility.waitUntilVisibility(By.xpath(XPATH_BUTTON_MY_CART));
        driver.findElement(By.xpath(XPATH_BUTTON_MY_CART)).click();
    }

    public boolean checkUsernameDisplay(String username) {
        return actionUtility.checkElementDisplay(By.xpath(String.format(XPATH_USERNAME, username)), 10);
    }

    public boolean checkLoginButtonDisplay() {
        return actionUtility.checkElementDisplay(By.cssSelector(CSS_LOGIN_BUTTON), 5);
    }

    public void searchWithKeyword(String keyword) {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_INPUT_SEARCH));
        driver.findElement(By.cssSelector(CSS_INPUT_SEARCH)).clear();
        driver.findElement(By.cssSelector(CSS_INPUT_SEARCH)).sendKeys(keyword);
        driver.findElement(By.cssSelector(CSS_INPUT_SEARCH)).sendKeys(Keys.ENTER);
    }

    public boolean checkListProductDisplayMatchWithKeywordAllPage(String keyword) throws Exception {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_LIST_PRODUCT_DISPLAY));
        return checkListProductDisplayMatchWithKeyword(keyword);
    }

    public boolean checkListProductDisplayMatchWithKeyword(String keyword) throws Exception {
        for (int i = 1; i < driver.findElements(By.xpath(XPATH_LIST_PRODUCT)).size(); i++) {
            String productName = driver.findElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i))).getText();

            if (!productName.toLowerCase().contains(keyword.toLowerCase())) {
                actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i)));
                throw new Exception("Product: " + productName + " does not match with " + keyword + " keyword");
            }
        }

        // check if result with pagination
        if (actionUtility.checkElementDisplay(By.xpath(XPATH_PAGINATION), 5)) {

            // check if current pagination is not the last page
            if (driver.findElements(By.xpath(XPATH_ICON_NEXT_PAGE_DISABLE)).size() > 0) {
                driver.findElement(By.xpath(XPATH_ICON_NEXT_PAGE_NOT_DISABLE)).click();
                waitUtility.waitForPageLoad();

                checkListProductDisplayMatchWithKeyword(keyword);
            }

        }

        return true;
    }

    public boolean checkListProductDisplayMatchWithBranchAllPage(String branch) throws Exception {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_LIST_PRODUCT_DISPLAY));
        return checkListProductDisplayMatchWithBranch(branch);
    }

    public boolean checkListProductDisplayMatchWithBranch(String branch) throws Exception {
        for (int i = 1; i < driver.findElements(By.xpath(XPATH_LIST_PRODUCT)).size(); i++) {
            String productName = driver.findElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i))).getText();

            switch (branch) {
                case "Adidas":
                case "Nike":
                    if (!productName.toLowerCase().contains(branch.toLowerCase())) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i)));
                        throw new Exception("Product: " + productName + " does not match with " + branch + " branch");
                    }
                    break;
                case "Bitis Hunter":
                    if (!productName.toLowerCase().contains("bitis") && !productName.toLowerCase().contains("hunter")) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i)));
                        throw new Exception("Product: " + productName + " does not match with " + branch + " branch");
                    }
                    break;
                case "Converse":
                    if (!productName.toLowerCase().contains("converse") && !productName.toLowerCase().contains("chuck")) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i)));
                        throw new Exception("Product: " + productName + " does not match with " + branch + " branch");
                    }
                    break;
                default:
                    throw new Exception("Currently we don't support this branch");

            }
        }

        // check if result with pagination
        if (actionUtility.checkElementDisplay(By.xpath(XPATH_PAGINATION), 5)) {

            // check if current pagination is not the last page
            if (driver.findElements(By.xpath(XPATH_ICON_NEXT_PAGE_DISABLE)).size() > 0) {
                driver.findElement(By.xpath(XPATH_ICON_NEXT_PAGE_NOT_DISABLE)).click();
                waitUtility.waitForPageLoad();

                checkListProductDisplayMatchWithBranch(branch);
            }

        }

        return true;
    }

    public boolean checkListProductDisplayMatchWithPriceAllPage(String price) throws Exception {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_LIST_PRODUCT_DISPLAY));
        return checkListProductDisplayMatchWithPrice(price);
    }

    public boolean checkListProductDisplayMatchWithPrice(String price) throws Exception {
        for (int i = 1; i < driver.findElements(By.xpath(XPATH_LIST_PRODUCT)).size(); i++) {
            String productName = driver.findElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i))).getText();
            int productPrice = actionUtility.getPrice(driver.findElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i))).getText());

            switch (price) {
                case "Dưới 1 triệu":
                    if (productPrice >= 1000000) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Product " + productName + " with price " + productPrice + " does not match with " + price + " price");
                    }
                    break;
                case "1-2 triệu":
                    if (productPrice < 1000000 || productPrice > 2000000) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Product " + productName + " with price " + productPrice + " does not match with " + price + " price");
                    }
                    break;
                case "2-5 triệu":
                    if (productPrice < 2000000 || productPrice > 5000000) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Product " + productName + " with price " + productPrice + " does not match with " + price + " price");
                    }
                    break;
                case "5-10 triệu":
                    if (productPrice < 5000000 || productPrice > 10000000) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Product " + productName + " with price " + productPrice + " does not match with " + price + " price");
                    }
                    break;
                case "10-20 triệu":
                    if (productPrice < 10000000 || productPrice > 20000000) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Product " + productName + " with price " + productPrice + " does not match with " + price + " price");
                    }
                    break;
                default:
                    throw new Exception("Currently we don't support this price");
            }

        }

        // check if result with pagination
        if (actionUtility.checkElementDisplay(By.xpath(XPATH_PAGINATION), 5)) {

            // check if current pagination is not the last page
            if (driver.findElements(By.xpath(XPATH_ICON_NEXT_PAGE_DISABLE)).size() > 0) {
                driver.findElement(By.xpath(XPATH_ICON_NEXT_PAGE_NOT_DISABLE)).click();
                waitUtility.waitForPageLoad();

                checkListProductDisplayMatchWithPrice(price);
            }

        }

        return true;
    }

    public boolean checkListProductDisplayMatchWithDiscountAllPage(String discount) throws Exception {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_LIST_PRODUCT_DISPLAY));
        return checkListProductDisplayMatchWithDiscount(discount);
    }

    public boolean checkListProductDisplayMatchWithDiscount(String discount) throws Exception {
        for (int i = 1; i < driver.findElements(By.xpath(XPATH_LIST_PRODUCT)).size(); i++) {
            String productName = driver.findElement(By.xpath(String.format(XPATH_PRODUCT_NAME_INDEX, i))).getText();
            int productPrice = actionUtility.getPrice(driver.findElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX_OLD, i))).getText());
            int productPriceDiscount = actionUtility.getPrice(driver.findElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX_DISCOUNT, i))).getText());

            switch (discount) {
                case "20% off":
                    if ((int) ((float) productPriceDiscount / productPrice * 100) != 80) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Discount of product " + productName + " does not match with " + discount + " discount with old price: " + productPrice + " and new price: " + productPriceDiscount);
                    }
                    break;
                case "30% off":
                    if ((int) ((float) productPriceDiscount / productPrice * 100) != 70) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Discount of product " + productName + " does not match with " + discount + " discount with old price: " + productPrice + " and new price: " + productPriceDiscount);
                    }
                    break;
                case "50% off":
                    if ((int) ((float) productPriceDiscount / productPrice * 100) != 50) {
                        actionUtility.scrollToElement(By.xpath(String.format(XPATH_PRODUCT_PRICE_INDEX, i)));
                        throw new Exception("Discount of product " + productName + " does not match with " + discount + " discount with old price: " + productPrice + " and new price: " + productPriceDiscount);
                    }
                    break;
                default:
                    throw new Exception("Currently we don't support this discount");
            }

        }

        // check if result with pagination
        if (actionUtility.checkElementDisplay(By.xpath(XPATH_PAGINATION), 5)) {

            // check if current pagination is not the last page
            if (driver.findElements(By.xpath(XPATH_ICON_NEXT_PAGE_DISABLE)).size() > 0) {
                driver.findElement(By.xpath(XPATH_ICON_NEXT_PAGE_NOT_DISABLE)).click();
                waitUtility.waitForPageLoad();

                checkListProductDisplayMatchWithDiscount(discount);
            }

        }

        return true;
    }

    public void addToCart(String name, String price) {
        driver.findElement(By.xpath(String.format(XPATH_BUTTON_ADD_TO_CART_OF_PRODUCT, name, price))).click();
    }

    public void clickOnABrandInMenuBar(String branch) {
        waitUtility.waitUntilVisibility(By.xpath(String.format(XPATH_MENU_BRANCH, branch)));
        driver.findElement(By.xpath(String.format(XPATH_MENU_BRANCH, branch))).click();
    }

    public void searchProductsWithInLeftMenu(String price) {
        waitUtility.waitUntilVisibility(By.xpath(String.format(XPATH_LEFT_PRICE, price)));
        driver.findElement(By.xpath(String.format(XPATH_LEFT_PRICE, price))).click();
    }

}
