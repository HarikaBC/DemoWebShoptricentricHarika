package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObject.CheckoutPage;

public class CheckOutSteps {

	WebDriver driver;
	WebDriverWait wait;
//	HomePage homePage;
//	SearchFunctionality searchFunctionality;
//	ProductDetailsPage productDetailsPage;
	CheckoutPage shoppingCart;

	@Before("@ShoppingCartTest")
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		homePage = new HomePage(driver);
//		searchFunctionality = new SearchFunctionality(driver, wait);
//		productDetailsPage = new ProductDetailsPage(driver, wait);
		shoppingCart = new CheckoutPage(driver, wait);
	}

	@Given("User Entered homepage")
	public void user_entered_homepage() {
		driver.get("http://demowebshop.tricentis.com/");
	}


	@When("User opened product  added to cart and opened the cart")
	public void  User_opened_product_added_to_cart_and_opened_the_cart() throws InterruptedException {
	
		shoppingCart.openCart();
		Thread.sleep(5000);
	}

	@When("User removes the product and updates the quantities")
	public void user_removes_the_product_and_updates_the_quantities() throws InterruptedException {

		shoppingCart.removeProduct1();
		Thread.sleep(5000);

	}

	

	@Then("Checkout page is displayed")
	public void checkout_page_is_displayed() {
		shoppingCart.verifyCheckoutPage();
	}

	@After("@ShoppingCartTest")
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

