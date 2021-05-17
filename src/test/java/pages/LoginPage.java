package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final String NAME_INPUT_USERNAME = "username";
    private static final String NAME_INPUT_PASS = "password";
    private static final String CSS_BUTTON_LOGIN = ".btn.btn-outline-dark";
    private static final String XPATH_ERROR_MESSAGE_INVALID_INFO = "//section[contains(text(),'Sai tên đăng nhập hoặc mật khẩu!')]";

    public LoginPage() {
    }

    public void inputEmail(String email) {
        waitUtility.waitUntilVisibility(By.name(NAME_INPUT_USERNAME));
        driver.findElement(By.name(NAME_INPUT_USERNAME)).sendKeys(email);
    }

    public void inputPassword(String password) {
        waitUtility.waitUntilVisibility(By.name(NAME_INPUT_PASS));
        driver.findElement(By.name(NAME_INPUT_PASS)).sendKeys(password);
    }

    public void clickOnLoginButton() {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_BUTTON_LOGIN));
        driver.findElement(By.cssSelector(CSS_BUTTON_LOGIN)).click();
    }

    public boolean checkErrorMessageInvalidInfoDisplay() {
        return actionUtility.checkElementDisplay(By.xpath(XPATH_ERROR_MESSAGE_INVALID_INFO), 10);
    }

    public boolean checkErrorMessageFieldBlankDisplay() {
        return actionUtility.getHTML5ValidationMessage(driver.findElement(By.name(NAME_INPUT_USERNAME))).equals("Please fill out this field.")
                || actionUtility.getHTML5ValidationMessage(driver.findElement(By.name(NAME_INPUT_PASS))).equals("Please fill out this field.");
    }
}
