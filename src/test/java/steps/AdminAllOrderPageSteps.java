package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.AdminAllOrderPage;
import pages.General;

public class AdminAllOrderPageSteps {
    private General general;
    private AdminAllOrderPage adminAllOrderPage;

    public AdminAllOrderPageSteps(General general, AdminAllOrderPage adminAllOrderPage) {
        this.general = general;
        this.adminAllOrderPage = adminAllOrderPage;
    }

    @And("go to Tất cả đơn hàng page")
    public void goToAllOrderPage() {
        general.goToAdminAllOrderPage();
    }

    @Then("verify the order has been placed is displayed in list")
    public void verifyTheOrderHasBeenPlacedIsDisplayedInList() {
        Assert.assertTrue("The order has been placed is not displayed in list", adminAllOrderPage.checkOrderPlacedDisplayedInList());
    }
}
