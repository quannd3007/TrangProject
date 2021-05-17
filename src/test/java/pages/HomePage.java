package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final String CSS_LOGIN_BUTTON = "#nav1 a[href*='login']";
    private static final String XPATH_USERNAME = "//button[contains(string(),'%s')]";

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

}
