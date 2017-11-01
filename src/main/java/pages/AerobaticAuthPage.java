package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AerobaticAuthPage {

    private WebDriver driver;

    private By standardAuthButton = By.cssSelector("a.button:first-child");

    public AerobaticAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public AerobaticAuthSuccessPage clickOnStandardAuthButton() {
        driver.findElement(standardAuthButton).click();
        return new AerobaticAuthSuccessPage(driver);
    }
}
