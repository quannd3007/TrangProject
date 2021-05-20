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

    @Then("verify product is displayed on Cart page")
    public void verifyProductIsAddedToCart(DataTable table) {
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
        String productName = map.get("name");
        Assert.assertTrue("Product " + productName + " is not displayed on Cart page", cartPage.checkProductDisplay(productName, map.get("price")));
    }

    @Then("verify product is not displayed on Cart page")
    public void verifyProductIsNotDisplayedOnCartPage(DataTable table) {
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);
        String productName = map.get("name");
        Assert.assertFalse("Product " + productName + " is still displayed on Cart page", cartPage.checkProductDisplay(productName, map.get("price")));
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

    @And("click on delete icon of product")
    public void clickOnDeleteIconOfProduct(DataTable table) {
        Map<String, String> map = (Map) table.asMaps(String.class, String.class).get(0);

        cartPage.clickOnDeleteIconOfProduct(map.get("name"), map.get("price"));
    }

    @Then("verify delete popup is displayed")
    public void verifyDeletePopupIsDisplayed() {
        Assert.assertTrue("Delete popup is not displayed", cartPage.checkDeletePopupIsDisplayed());
    }

    @Then("verify delete popup is not displayed")
    public void verifyDeletePopupIsNotDisplayed() {
        Assert.assertFalse("Delete popup is still displayed", cartPage.checkDeletePopupIsDisplayed());
    }

    @And("click on button Hủy on delete popup")
    public void clickOnButtonCancelOnDeletePopup() {
        cartPage.clickOnButtonCancelOnDeletePopup();
    }

    @And("click on button OK on delete popup")
    public void clickOnButtonOKOnDeletePopup() {
        cartPage.clickOnButtonOKOnDeletePopup();
    }

    @And("click on button Xóa tất cả")
    public void clickOnButtonDeleteAll() {
        cartPage.clickOnButtonDeleteAll();
    }


    @Then("verify the screen displayed message Giỏ hàng trống")
    public void verifyTheScreenDisplayedMessageCartEmpty() {
        Assert.assertTrue("Message Giỏ hàng trống is not displayed", cartPage.checkTheScreenDisplayedMessageCartEmpty());
    }

    @And("click on button Đặt Hàng")
    public void clickOnButtonCheckout() {
        cartPage.clickOnButtonCheckout();
    }

    @Then("^verify the message (.*) is displayed$")
    public void verifyTheMessageDeleteAllItemsIsDisplayed(String message) {
        Assert.assertTrue("Message " + message + " is not displayed", cartPage.checkMessageDeleteAllItems());
    }
}
