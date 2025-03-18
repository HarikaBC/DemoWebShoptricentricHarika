package stepDefinitions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchFunctionalitySteps {
	WebDriver driver;
	WebDriverWait wait;
	
	@Before("@SearchFunctionality")
	public void setup() {
		 driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	}
	
	@Given("User is in the search page")
	public void User_is_in_the_search_page() {
		driver.get("http://demowebshop.tricentis.com/");
	}

	@When("User search for product")
	public void user_search_for_product() throws InterruptedException {
	    WebElement search=driver.findElement(By.id("small-searchterms"));
	    search.sendKeys("laptop");
	    search.sendKeys(Keys.ENTER);
	    Thread.sleep(3000);	}
	@When("User filters the given results")
	public void User_filters_the_given_results() throws InterruptedException {
	    WebElement book=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("As")));
	    book.click();
	    WebElement category=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Cid")));
	    category.click();
	    Select select1=new Select(category);
	    select1.selectByVisibleText("All");
	    WebElement manufacturer=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Mid")));
	    manufacturer.click();
	    Thread.sleep(1000);
	    Select select2=new Select(manufacturer);
	    select2.selectByVisibleText("All");
	    driver.findElement(By.id("Pf")).sendKeys("1000");
	    Thread.sleep(1000);
	    driver.findElement(By.id("Pt")).sendKeys("25000");
	    Thread.sleep(1000);
	    driver.findElement(By.id("Sid")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/form/div[3]/input")).click();
	Thread.sleep(3000);
	}
	@Then("User should see the filtered results")
	public void User_should_see_the_filtered_results() {
	    WebElement result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-grid")));
	    if(result.isDisplayed()) 
	    	System.out.println("Filtered results found");
	    else
	    	System.out.println("No results for the filters");
	}

	@After
	public void tearDown() {
		if (driver!=null)
			driver.quit();
	}
}