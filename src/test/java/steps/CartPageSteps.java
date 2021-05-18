package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import pages.CartPage;

import java.util.Map;

public class CartPageSteps {

    private CartPage cartPage;

    public CartPageSteps(CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @Then("verify Cart page is displayed")
    public void verifyCartPageIsDisplayed() {
        Assert.assertTrue("Cart page is not displayed", cartPage.checkCartPageDisplay());
    }

    @Then("verify product is added to cart")
    public void verifyProductIsAddedToCart(DataTable table) {
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
        String productName = map.get("name");
        Assert.assertTrue("Product " + productName + " is not displayed on Cart page", cartPage.checkCartPageDisplay());
        cartPage.checkProductDisplay(productName, map.get("price"));
    }

    @And("change size and quantity of product")
    public void changeSizeAndQuantityOfProduct(DataTable table) {
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);

        cartPage.changeSizeAndQtyProduct(map.get("name"), map.get("price"), map.get("size"), map.get("quantity"));
    }

    @And("click on button Cập nhật")
    public void clickOnButtonUpdate() {
        cartPage.clickOnUpdateButton();
    }

    @Then("verify size and quantity of product")
    public void verifySizeAndQuantityOfProduct(DataTable table) {
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);

        Assert.assertTrue("Size and quantity of product are incorrect", cartPage.checkProductDisplayWithSizeAndQty(map.get("name"), map.get("price"), map.get("size"), map.get("quantity")));
    }
}
