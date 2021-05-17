package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;

public class LoginPageSteps {
    private LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @And("^input username as (.*)$")
    public void inputEmailAs(String email) {
        loginPage.inputEmail(email);
    }

    @And("^input password as (.*)$")
    public void inputPasswordAs(String password) {
        loginPage.inputPassword(password);
    }

    @And("submit login")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("verify error message \"Sai tên đăng nhập hoặc mật khẩu!\" is displayed")
    public void verifyErrorMessageSaiTenDangNhapHoacMatKhauIsDisplayed() {
        Assert.assertTrue("Error message Sai tên đăng nhập hoặc mật khẩu! is not displayed", loginPage.checkErrorMessageInvalidInfoDisplay());
    }

    @Then("verify error message \"Please fill out this field.\" is displayed")
    public void verifyErrorMessageIsDisplayed() {
        Assert.assertTrue("Error message Please fill out this field. is not displayed", loginPage.checkErrorMessageFieldBlankDisplay());
    }
}
