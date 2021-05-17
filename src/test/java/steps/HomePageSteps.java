package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {
    private HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        homePage.clickLoginButton();
    }

    @Then("verify username {} is displayed on menu bar")
    public void verifyUsernameIsDisplayedOnMenuBar(String username) {
        Assert.assertTrue("Username" + username + " is not displayed on menu bar", homePage.checkUsernameDisplay(username));
    }

    @Then("verify login button is not displayed on menu bar")
    public void verifyLoginButtonIsNotDisplayedOnMenuBar() {
        Assert.assertFalse("Login button is still displayed on menu bar", homePage.checkLoginButtonDisplay());
    }
}
