package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutUserInfo {


    private static WebDriver driver;
    // Page elements using By locators
    private static final By firstname = By.id("first-name");
    private static final By lastname = By.id("last-name");

    private static final By zipcode = By.id("postal-code");

    private static final By continuebutton = By.id("continue");



    public CheckoutUserInfo(WebDriver driver) {
        this.driver = driver;
    }


    public static void enterfirtname() {
        driver.findElement(firstname).sendKeys("TestFirst");
    }


    public static void enterlastname() {
        driver.findElement(lastname).sendKeys("TestLast");
    }

    public static void zipcode() {
        driver.findElement(zipcode).sendKeys("12345");
    }
    public static void continuepayment() {
        driver.findElement(continuebutton).click();
    }


}
