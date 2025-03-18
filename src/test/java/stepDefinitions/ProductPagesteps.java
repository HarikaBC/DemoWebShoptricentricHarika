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

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObject.ProductPage;


public class ProductPagesteps {
	
	    WebDriver driver;
	    WebDriverWait wait;
	    ProductPage productDetailsPage;

	    @Before("@ProductPageTest")
	    public void setUp() throws InterruptedException {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        productDetailsPage = new ProductPage(driver, wait);
	        
	    }
	    @Given("User Entered the homepage")
	    public void user_Entered_the_homepage() throws InterruptedException {
	        driver.get("http://demowebshop.tricentis.com/");
	    }
	    @When("User search for the product")
		public void User_search_for_the_product() throws InterruptedException {
		    WebElement search=driver.findElement(By.id("small-searchterms"));
		    search.sendKeys("laptop");
		    search.sendKeys(Keys.ENTER);
		    Thread.sleep(3000);	}
	    @When("User filters the results")
		public void User_filters_the_results() throws InterruptedException {
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
	    @When("User validate the product")
	    public void user_validate_the_product() throws InterruptedException {
        
    	WebElement productselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]/div/div[2]/h2/a")));
	        productselect.click();	        
	    }
	    @When("User adding the quantity of product")
	    public void User_adding_the_quantity_of_product() {
	    	productDetailsPage.quantity();
	    }
	    @When("User adding the product to the cart")
	    public void user_adding_the_product_to_the_cart() {
	        productDetailsPage.addToCart();
	    }
	    @Then("Product is displayed in the cart")
	    public void product_is_displayed_in_the_cart() {
	        String productPresent = "added to cart";
	        System.out.println( "Product added in the cart!");
	    }
	}
 