package pages;

import org.openqa.selenium.By;

public class LoginAdminPage extends BasePage {

    private static final String NAME_INPUT_USERNAME = "username";
    private static final String NAME_INPUT_PASS = "password";
    private static final String CSS_BUTTON_LOGIN = ".btn.btn-outline-dark";
    private static final String XPATH_USERNAME = "//button[contains(string(),'trangpu')]";

    public LoginAdminPage() {
    }

    public void login() {
        waitUtility.waitUntilVisibility(By.name(NAME_INPUT_USERNAME));
        waitUtility.waitUntilToBeClickAble(By.name(NAME_INPUT_USERNAME));
        driver.findElement(By.name(NAME_INPUT_USERNAME)).sendKeys("trangpu");
        driver.findElement(By.name(NAME_INPUT_PASS)).sendKeys("123456");
        driver.findElement(By.cssSelector(CSS_BUTTON_LOGIN)).click();

        waitUtility.waitUntilVisibility(By.xpath(XPATH_USERNAME));
    }

}
