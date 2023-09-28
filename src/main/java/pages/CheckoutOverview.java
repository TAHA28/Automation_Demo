package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview {

    private static WebDriver driver;
    // Page elements using By locators
    private static final By FinishButton = By.id("finish");

    private static final By successmessage = By.cssSelector(".complete-header");




    public CheckoutOverview(WebDriver driver) {
        this.driver = driver;
    }

    public static void FinishOrder() {
        driver.findElement(FinishButton).click();
    }

    public static String assertSuccessMessage() {
        return driver.findElement(successmessage).getText();
    }
}
