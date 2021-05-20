package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.OrderPage;

public class OrderPageSteps {

    private OrderPage orderPage;

    public OrderPageSteps(OrderPage orderPage) {
        this.orderPage = orderPage;
    }

    @And("delete all field")
    public void deleteAllField() {
        orderPage.deleteAllField();
    }

    @And("click on button Xác nhận")
    public void clickOnButtonSubmit() {
        orderPage.clickOnButtonSubmit();
    }

    @Then("verify message required fields is displayed")
    public void verifyMessageRequiredFieldsIsDisplayed() {
        Assert.assertTrue("Message required filed is not displayed", orderPage.checkMessageRequiredFiledDisplay());
    }

    @Then("^verify customer name displays as (.*)$")
    public void verifyCustomerNameDisplaysAs(String name) {
        Assert.assertEquals("Customer name is incorrect", name, orderPage.getFullName());
    }

    @Then("^verify customer mobile displays as (.*)$")
    public void verifyCustomerMobileDisplaysAs(String number) {
        Assert.assertEquals("Customer mobile is incorrect", number, orderPage.getMobile());
    }

    @Then("^verify customer email displays as (.*)$")
    public void verifyCustomerEmailDisplaysAs(String email) {
        Assert.assertEquals("Customer email is incorrect", email, orderPage.getEmail());
    }

    @Then("^verify customer address displays as (.*)$")
    public void verifyCustomerAddressDisplaysAs(String address) {
        Assert.assertEquals("Customer address is incorrect", address, orderPage.getAddress());
    }

    @Then("^verify receiver name displays as (.*)$")
    public void verifyReceiverNameDisplaysAs(String name) {
        Assert.assertEquals("Receiver name is incorrect", name, orderPage.getReceiver());
    }

    @Then("^verify receiver mobile displays as (.*)$")
    public void verifyReceiverMobileDisplaysAs(String number) {
        Assert.assertEquals("Receiver mobile is incorrect", number, orderPage.getReceiverMobile());
    }

    @Then("^verify receiver address displays as (.*)$")
    public void verifyReceiverAddressDisplaysAs(String address) {
        Assert.assertEquals("Receiver address is incorrect", address, orderPage.getReceiverAddress());
    }

    @And("^update receiver name to (.*)$")
    public void updateReceiverNameTo(String name) {
        orderPage.updateReceiver(name);
    }

    @And("^update receiver mobile to (.*)$")
    public void updateReceiverMobileTo(String mobile) {
        orderPage.updateReceiverMobile(mobile);
    }

    @And("^update receiver address to (.*)$")
    public void updateReceiverAddressTo(String address) {
        orderPage.updateReceiverAddress(address);
    }

    @And("^select payment method as (.*)$")
    public void selectPaymentMethodAs(String methodName) {
        orderPage.selectPaymentMethodAs(methodName);
    }

    @Then("^verify payment method (.*) is selected$")
    public void verifyPaymentMethodIsSelected(String methodName) {
        Assert.assertTrue("Payment method " + methodName + " is not selected", orderPage.checkPaymentMethodSelected(methodName));
    }

    @And("click on button Xác nhận đặt hàng")
    public void clickOnButtonPlaceOrder() {
        orderPage.clickOnButtonPlaceOrder();
    }

    @Then("^message (.*) is displayed$")
    public void messagePlaceOrderSuccessIsDisplayed(String message) {
        Assert.assertTrue("Place order successfully popup is not displayed", orderPage.checkPlaceOrderSuccessPopupIsDisplayed());
        Assert.assertEquals("Message " + message + "is not displayed", message, orderPage.getPlaceOrderSuccessMessage());
    }
}
