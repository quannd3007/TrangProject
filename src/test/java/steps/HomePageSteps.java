package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.HomePage;

import java.util.Map;

public class HomePageSteps {
    private HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @And("click on login button")
    public void clickOnLoginButton() {
        homePage.clickLoginButton();
    }

    @Then("^verify username (.+?) is displayed on menu bar$")
    public void verifyUsernameIsDisplayedOnMenuBar(String username) {
        Assert.assertTrue("Username" + username + " is not displayed on menu bar", homePage.checkUsernameDisplay(username));
    }

    @Then("verify login button is not displayed on menu bar")
    public void verifyLoginButtonIsNotDisplayedOnMenuBar() {
        Assert.assertFalse("Login button is still displayed on menu bar", homePage.checkLoginButtonDisplay());
    }

    @And("^search with keyword (.+?)$")
    public void searchWithKeyword(String keyword) {
        homePage.searchWithKeyword(keyword);
    }

    @Then("^the screen displays products match with (.+?) keyword$")
    public void theScreenDisplaysProductsMatchWithInputtedKeyword(String keyword) throws Exception {
        Assert.assertTrue("Still have product that does not match with " + keyword + " keyword", homePage.checkListProductDisplayMatchWithKeywordAllPage(keyword));
    }

    @And("click add to cart of product")
    public void clickAddToCartOfProduct(DataTable table) {
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);

        homePage.addToCart(map.get("name"), map.get("price"));
    }
}
