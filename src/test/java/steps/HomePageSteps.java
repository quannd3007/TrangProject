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

    @And("click on button Giỏ hàng của tôi")
    public void clickOnButtonMyCart() {
        homePage.clickMyCartButton();
    }

    @And("^click on (.+?) brand in menu bar$")
    public void clickOnABrandInMenuBar(String branch) {
        homePage.clickOnABrandInMenuBar(branch);
    }

    @Then("^the screen displays products match with (.+?) branch$")
    public void theScreenDisplaysProductsMatchWithBranch(String branch) throws Exception {
        Assert.assertTrue("Still have product that does not match with " + branch + " branch", homePage.checkListProductDisplayMatchWithBranchAllPage(branch));
    }

    @And("^search products with price (.+?) on left menu$")
    public void searchProductsWithInLeftMenu(String price) {
        homePage.searchProductsWithInLeftMenu(price);
    }

    @Then("^the screen displays products match with (.+?) price")
    public void theScreenDisplaysProductsMatchWithPrice(String price) throws Exception {
        Assert.assertTrue("Still have product that does not match with " + price + " price", homePage.checkListProductDisplayMatchWithPriceAllPage(price));
    }

    @And("^search products with discount (.+?) on left menu$")
    public void searchProductsWithDiscountInLeftMenu(String discount) {
        homePage.searchProductsWithInLeftMenu(discount);
    }

    @Then("^the screen displays products match with (.+?) discount")
    public void theScreenDisplaysProductsMatchWithDiscount(String discount) throws Exception {
        Assert.assertTrue("Still have product that does not match with " + discount + " discount", homePage.checkListProductDisplayMatchWithDiscountAllPage(discount));
    }
}
