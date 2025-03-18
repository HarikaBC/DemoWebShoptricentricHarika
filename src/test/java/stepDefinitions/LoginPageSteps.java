package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObject.ProductPage;

import pageObject.LoginPage;

import org.testng.Assert;

public class LoginPageSteps {
    WebDriver gistrationStepsdriver;
    WebDriverWait wait;
    ProductPage productDetailsPage;
   LoginPage userRegistration;

    @Before("@UserRegistrationTest")
    public void setUp() {
        gistrationStepsdriver = new ChromeDriver();
        gistrationStepsdriver.manage().window().maximize();
        wait = new WebDriverWait(gistrationStepsdriver, Duration.ofSeconds(10));
        userRegistration = new LoginPage(gistrationStepsdriver, wait);
    }

    @Given("User on homepage")
    public void User_on_homepage() {
        gistrationStepsdriver.get("http://demowebshop.tricentis.com/");
    }

    @When("User registers an account")
    public void User_registers_an_account() throws InterruptedException {
        
        userRegistration.clickSignup();
        }
    @When("User logs in with Email {string} and password {string}")
    public void User_logs_in_with_Email_and_password(String Email, String password) throws InterruptedException {
    	userRegistration.clickLogin();
    	userRegistration.clickLogin();
        userRegistration.login(Email, password);
        Thread.sleep(5000);
    }
    @Then("displays registered changed successfully")
    public void displays_registered_changed_successfully() {
        Assert.assertTrue(userRegistration.isregisteredSuccessfully(), "Your registration completed");
    }
     @After("@UserRegistrationTest")
    public void tearDown() {
        if (gistrationStepsdriver != null) {
            gistrationStepsdriver.quit();
        }
    }
}
