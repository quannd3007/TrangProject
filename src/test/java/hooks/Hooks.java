package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverFactory;
import driver.SharedDriver;

public class Hooks extends StepHelper {

    private SharedDriver driver;

    public Hooks(SharedDriver driver) {
        this.driver = driver;
    }

    @Before
    public void setUp() throws Exception {
        driver.initialize();
    }

    @After
    public void tearDown() {
        saveScreenshot();
        DriverFactory.quitDriver();
    }
}
