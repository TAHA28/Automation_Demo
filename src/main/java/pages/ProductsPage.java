package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private static WebDriver driver;
    // Page elements using By locators
    private static final By addtocart = By.id("add-to-cart-sauce-labs-backpack");
    private static final By gotocart= By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void addtocart() {
        driver.findElement(addtocart).click();
    }

    public static void opencart() {
        driver.findElement(gotocart).click();
    }

}
