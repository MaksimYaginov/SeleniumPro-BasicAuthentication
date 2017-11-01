package helpers;

import pages.AerobaticAuthPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Helper {

    public static AerobaticAuthPage goToAerobaticAuthPage(String url, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        return new AerobaticAuthPage(driver);
    }
}
