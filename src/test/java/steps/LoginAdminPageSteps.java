package steps;

import cucumber.api.java.en.And;
import pages.General;
import pages.LoginAdminPage;

public class LoginAdminPageSteps {
    private General general;
    private LoginAdminPage loginAdminPage;

    public LoginAdminPageSteps(General general, LoginAdminPage loginAdminPage) {
        this.general = general;
        this.loginAdminPage = loginAdminPage;
    }

    @And("login to Admin page")
    public void loginToAdminPage() {
        general.goToLoginAdminPage();
        loginAdminPage.login();
    }
}
