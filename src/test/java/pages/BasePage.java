package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import utility.ActionUtility;
import utility.WaitUtility;

public abstract class BasePage {

    public WebDriver driver;
    public WaitUtility waitUtility;
    public ActionUtility actionUtility;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        initComponents();
    }

    private void initComponents() {
        waitUtility = new WaitUtility(driver);
        actionUtility = new ActionUtility(driver);
    }

}
