package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AerobaticAuthSuccessPage {

    private WebDriver driver;

    private By pageTitle = By.cssSelector("h1.title");

    public AerobaticAuthSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean authSuccess() {
        WebElement authSuccessTitle = driver.findElement(pageTitle);
        boolean authSuccess = authSuccessTitle.isDisplayed() && authSuccessTitle.getText().equals("Auth Success");
        return authSuccess;
    }
}
