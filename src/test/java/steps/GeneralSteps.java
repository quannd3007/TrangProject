package steps;

import cucumber.api.java.en.Given;
import hooks.StepHelper;
import pages.General;

public class GeneralSteps extends StepHelper {

    private General general;

    public GeneralSteps(General general) {
        this.general = general;
    }

    @Given("go to home page")
    public void goToHomePage() {
        general.goToHomePage();
    }
}
