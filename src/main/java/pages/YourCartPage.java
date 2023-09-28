package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage {

    private static WebDriver driver;
    // Page elements using By locators
    private static final By checkoutButton = By.id("checkout");
    //private static final By gotocart= By.cssSelector(".shopping_cart_link");

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void proceedCheckout() {
        driver.findElement(checkoutButton).click();
    }

}
