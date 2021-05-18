package driver;

import java.io.File;

public interface CustomSeleniumDriver {

    byte[] takeScreenShot();

    File getScreenshot();

    byte[] screenShot();
}