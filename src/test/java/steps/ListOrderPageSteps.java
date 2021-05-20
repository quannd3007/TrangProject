package steps;

import cucumber.api.java.en.Then;
import hooks.StepHelper;
import pages.ListOrderPage;

public class ListOrderPageSteps {

    private ListOrderPage listOrderPage;

    public ListOrderPageSteps(ListOrderPage listOrderPage) {
        this.listOrderPage = listOrderPage;
    }

    @Then("verify the order has been placed is displayed")
    public void verifyTheOrderHasBeenPlacedIsDisplayed() {
        StepHelper.orderNumber = listOrderPage.getOrderNumber();
        System.out.println("orderNumber: " + StepHelper.orderNumber);
    }
}
