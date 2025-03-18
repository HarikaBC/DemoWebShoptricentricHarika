package stepDefinitions;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObject.*;

	public class OrderFunctionalitySteps {
	    public WebDriver driver;
	    public WebDriverWait wait;
	    public OrderPage order;
	    public CheckoutPage shoppingCart;
	    private By cartIcon=By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[6]/a");
	    private By productlink = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/h2/a");
	    private By cartopenButton = By.xpath("//*[@id=\"bar-notification\"]/p/a");
	    private By addToCartButton2 = By.id("add-to-cart-button-28");
	    private By addToCartButton1 = By.id("add-to-cart-button-14");
	    public By emailField = By.id("Email");
	    public By passwordField = By.id("Password");
	    
@Before("@OrderTest")
	 public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        this.order = new OrderPage(driver, wait);
	    
	    }
	    @Given("User is on Home Page to order")
	    public void User_is_on_Home_Page_to_order() {
	    	driver.get("http://demowebshop.tricentis.com/");
	    }

	    @When("User visit cart for ordering the product and will checkout")
	    public void User_visit_cart_for_ordering_the_product_and_will_checkout() throws InterruptedException {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
	        driver.findElement(cartIcon).click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(productlink));
	        driver.findElement(productlink).click();
	        Thread.sleep(2000);
	        driver.findElement(By.id("addtocart_14_EnteredQuantity")).sendKeys("1");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton1));
	        driver.findElement(addToCartButton1).click();
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(cartopenButton));
	        driver.findElement(cartopenButton).click();
	        Thread.sleep(2000);
	        WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[1]/div[3]/ul/li[4]/a")));
	 	    link.click();
	    	WebElement Country=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CountryId")));
	 	    Country.click();
	 	    Select select1=new Select(Country);
	 	    select1.selectByVisibleText("India");
	 	   WebElement agree1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice")));
		    agree1.click();
	 	    WebElement checkout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
		    checkout.click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys("radhab23@gmail.com");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys("123456");
	 	   //driver.findElement(zipCode).sendKeys("560092");
	        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")));
	 	    login.click();
	 	   WebElement agree2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice")));
		    agree2.click();
		    WebElement checkout1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
		    checkout1.click();
	        
	    
	    }
	    @When("User should fill billing adress and details and payment method")
	    public void User_should_fill_billing_adress_and_details_and_payment_method() throws InterruptedException  {
	    	//order.enterBillingDetails();
	    	order.clickContinue();
	    	order.clickContinue2();
	    	order.clickContinue3();
	    	order.clickContinue4();
	    	order.clickContinue5();
	    	//order.submit();
	    }
	    @When("User orders the product")
	    public void User_orders_the_product() {
	    	order.submit();
	    	order.submit2();
	    }
	    @Then("Order details is displayed")
	    public void order_details_is_displayed() {
	        order.display();
	    }
	    @After("@OrderTest")
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

