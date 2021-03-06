package pages;

public class General extends BasePage {
    public General() {
    }

    public void goToHomePage() {
        driver.get("http://trang-project.herokuapp.com/");
        waitUtility.waitForPageLoad();
    }

    public void goToCartPage() {
        driver.get("http://trang-project.herokuapp.com/cart");
        waitUtility.waitForPageLoad();
    }

    public void goToLoginAdminPage() {
        driver.get("http://trang-project.herokuapp.com/admin/login");
        waitUtility.waitForPageLoad();
    }

    public void goToAdminAllOrderPage() {
        driver.get("http://trang-project.herokuapp.com/admin/order");
        waitUtility.waitForPageLoad();
    }
}
