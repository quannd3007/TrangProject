package pages;

import org.openqa.selenium.By;

public class ListOrderPage extends BasePage {

    private static final String CSS_TABLE_LIST_ORDER = "table.table";
    private static final String CSS_ORDER_NUMBER = "table.table tr:last-of-type th";

    public ListOrderPage() {
    }

    public String getOrderNumber() {
        waitUtility.waitUntilVisibility(By.cssSelector(CSS_ORDER_NUMBER));
        return driver.findElement(By.cssSelector(CSS_ORDER_NUMBER)).getText();
    }
}
