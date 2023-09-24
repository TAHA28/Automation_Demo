package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.loginPage;

public class Login {

    private WebDriver driver;
    private loginPage LoginPage; // Instantiate the Page Object class
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ ("/src/main/java/drivers/chromedriver.exe"));
        ChromeOptions chromeoptions= new ChromeOptions();
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver= new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
        LoginPage = new loginPage(driver); // Initialize the Page Object class
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
    public void user_clicks_the_Login_button() {
        loginPage.clickLoginButton(); // Use method from the Page Object class
    }


    @When("User gets the validation message")
    public void user_gets_the_validation_message() {
        String pageMessage= loginPage.assertError(); // Use method from the Page Object class

        assert pageMessage.equals("Epic sadface: Username and password do not match any user in this service");
        System.out.println(pageMessage);
    }
}
