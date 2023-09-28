package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

public class Login {

    private WebDriver driver;
    private loginPage LoginPage; // Instantiate the Page Object class
    private ProductsPage product;

    private YourCartPage Cart;

    private CheckoutUserInfo Checkout;

    private CheckoutOverview overview;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ ("/src/main/java/drivers/chromedriver.exe"));
        ChromeOptions chromeoptions= new ChromeOptions();
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
        LoginPage = new loginPage(driver); // Initialize the Page Object class
        product= new ProductsPage(driver);
        Cart= new YourCartPage(driver);
        Checkout= new CheckoutUserInfo(driver);
        overview= new CheckoutOverview(driver);
    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Given("User navigates to WebPage {string}")
    public void web_browser_is_open_and_working_properly(String URL) throws InterruptedException {
        driver.get(URL);
        Thread.sleep(5000);
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks the Login button")
    public void user_clicks_the_Login_button() throws InterruptedException {
        loginPage.clickLoginButton(); // Use method from the Page Object class
        Thread.sleep(4000);
    }


    @When("User gets the validation message")
    public void user_gets_the_validation_message() {
        String pageMessage= loginPage.assertError(); // Use method from the Page Object class

        assert pageMessage.equals("Epic sadface: Username and password do not match any user in this service");
        System.out.println(pageMessage);
    }

    @When("User add product to cart")
    public void user_add_product_to_cart() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        ProductsPage.addtocart();
        Thread.sleep(4000);
    }

    @When("User Open Cart")
    public void user_open_cart() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        ProductsPage.opencart();
        Thread.sleep(4000);
    }

    @When("Proceed Checkout")
    public void user_checkout_cart() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        YourCartPage.proceedCheckout();
        Thread.sleep(4000);
    }

    @When("Enter Contact Information")
    public void user_enterinfo_for_checkout() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        CheckoutUserInfo.enterfirtname();
        CheckoutUserInfo.enterlastname();
        CheckoutUserInfo.zipcode();
        CheckoutUserInfo.continuepayment();

        Thread.sleep(4000);
    }

    @When("Finish Order")
    public void finish_order() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        CheckoutOverview.FinishOrder();
        Thread.sleep(4000);
    }

    @When("User completed order and gets success message validation")
    public void user_gets_success_validation_message() {
        String successMessage= CheckoutOverview.assertSuccessMessage();
        assert successMessage.equals("Thank you for your order!");
        System.out.println(successMessage);
    }
}
