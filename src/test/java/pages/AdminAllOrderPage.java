package pages;

import hooks.StepHelper;
import org.openqa.selenium.By;

public class AdminAllOrderPage extends BasePage {

    private static final String XPATH_ORDER_NUMBER = "//a[@href='http://trang-project.herokuapp.com/admin/edit/order/%s']";

    public AdminAllOrderPage() {
    }

    public boolean checkOrderPlacedDisplayedInList() {
        return actionUtility.checkElementDisplay(By.xpath(String.format(XPATH_ORDER_NUMBER, StepHelper.orderNumber)), 30);
    }
}
