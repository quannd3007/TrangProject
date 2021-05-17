package pages;

public class General extends BasePage {
    public General() {
    }

    public void goToHomePage() {
        driver.get("http://trang-project.herokuapp.com/");
        waitUtility.waitForPageLoad();
    }

}
