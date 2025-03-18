package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;

public class HomePageSteps {
	WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
	
    @Before("@SearchTest")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }
	@Given("User is on Home Page")
	public void user_is_on_the_homepage() {
		// Write code here that turns the phrase above into concrete actions
        driver.get("https://demowebshop.tricentis.com/");
	}
	@When("User searches for {string}")
	public void user_searches_for_Product(String product) {
		// Write code here that turns the phrase above into concrete actions
		homePage.searchForproduct(product);
	}
	@Then("Search results should be displayed")
	public void search_results_are_displayed() {
		String actualTitle=homePage.getPageTitle();
		String expectedTitle = "Demo Web Shop. Search";
		Assert.assertEquals(actualTitle,expectedTitle);
		// Checking whether the element displays or not...
		boolean isBookPresent = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img")).size() > 0;
	    Assert.assertTrue(isBookPresent, "Demo Web Shop. Search");
		// Write code here that turns the phrase above into concrete actions		
	}
	@After("@SearchTest")
    public void tearDown() {
        driver.quit();
    }
}
