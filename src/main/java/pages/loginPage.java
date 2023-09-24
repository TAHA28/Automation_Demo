package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class loginPage {

    private static WebDriver driver;
    // Page elements using By locators
    private static final By usernameField = By.id("user-name");
    private static final By passwordField = By.id("password");
    private static final By loginButton = By.id("login-button");

    private static final By errorMessage= By.cssSelector("h3[data-test='error']");

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with page elements
    public static void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public static void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public static void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public static String assertError() {
        return driver.findElement(errorMessage).getText();
    }

}
