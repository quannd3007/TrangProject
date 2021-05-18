package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import hooks.StepHelper;
import pages.General;

public class GeneralSteps extends StepHelper {

    private General general;

    public GeneralSteps(General general) {
        this.general = general;
    }

    @Given("go to Home page")
    public void goToHomePage() {
        general.goToHomePage();
    }

    @And("go to Cart page")
    public void goToCartPage() {
        general.goToCartPage();
    }
}
