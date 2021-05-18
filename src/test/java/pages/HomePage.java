package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends BasePage {

    private static final String CSS_LOGIN_BUTTON = "#nav1 a[href*='login']";
    private static final String XPATH_USERNAME = "//button[contains(string(),'%s')]";
    private static final String CSS_INPUT_SEARCH = "input.form-control.mr-2";
    private static final String CSS_LIST_PRODUCT_DISPLAY = "aside.main section.row section.product";

    public HomePage() {
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector(CSS_LOGIN_BUTTON)).click();
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
        for (int i = 1; i < driver.findElements(By.xpath("//section[@class='row']/section[contains(@class,'product')]")).size(); i++) {
            String productName = driver.findElement(By.xpath("//section[@class='row']/section[contains(@class,'product')][" + i + "]//section[@class='productName']")).getText();

            if (!productName.toLowerCase().contains(keyword.toLowerCase())) {
                actionUtility.scrollToElement(By.xpath("//section[@class='row']/section[contains(@class,'product')][" + i + "]//section[@class='productName']"));
                throw new Exception("Product: " + productName + " does not match with " + keyword + " keyword");
            }
        }

        // check if result with pagination
        if (actionUtility.checkElementDisplay(By.xpath("//ul[@class='pagination']/li"), 5)) {

            // check if current pagination is not the last page
            if (driver.findElements(By.xpath("//ul[@class='pagination']/li[last()][not(contains(@class,'disabled'))]")).size() > 0) {
                driver.findElement(By.xpath("//ul[@class='pagination']/li[last()]")).click();
                waitUtility.waitForPageLoad();

                checkListProductDisplayMatchWithKeyword(keyword);
            }

        }

        return true;
    }

    public void addToCart(String name, String price) {
        driver.findElement(By.xpath("//section[@class='row']/section[contains(@class,'product')][.//section[@class='productName'][contains(text(),'" + name + "')]][.//section[@class='price'][contains(text(),'" + price + "')]][1]//a[contains(@class,'btn-outline-info')]")).click();
    }

}
