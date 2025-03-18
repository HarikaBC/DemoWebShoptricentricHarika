package pageObject;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class OrderPage {
	    private WebDriver driver;
	    private WebDriverWait wait;

	    private By firstName = By.id("BillingNewAddress_FirstName");
	    private By lastName = By.id("BillingNewAddress_LastName");
	    private By email = By.id("BillingNewAddress_Email");
	    private By countryDropdown = By.id("BillingNewAddress_CountryId");
	    private By city = By.id("BillingNewAddress_City");
	    private By address = By.id("BillingNewAddress_Address1");
	    private By address2 = By.id("BillingNewAddress_Address2");
	    private By zipCode = By.id("BillingNewAddress_ZipPostalCode");
	    private By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
	    private By continueButton = By.xpath("//input[@title='Continue']");
	    public By productTitle = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong");
	    // Constructor
	    public OrderPage(WebDriver driver, WebDriverWait wait) {
	        this.driver = driver;
	        this.wait = wait;
	    }

	    // Methods to fill in billing details
	    public void enterBillingDetails() throws InterruptedException {
 WebElement Country1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BillingNewAddress_CountryId")));
	 	    Country1.click();
	 	    Select select1=new Select(Country1);
	 	    select1.selectByVisibleText("India");
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(city)).sendKeys("banglore");
	    	Thread.sleep(1000);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys("hebbal");
	    	Thread.sleep(1000);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(address2)).sendKeys("kodigehalli");
	    	Thread.sleep(1000);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys("560092");
	    	Thread.sleep(1000);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).sendKeys("8198765564");
	    	Thread.sleep(1000);
	    }
	    public void checkout() throws InterruptedException {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[1]/div[3]/ul/li[4]/a")));
	 	    link.click();
	 	   Thread.sleep(1000);
	    	WebElement Country=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CountryId")));
	 	    Country.click();
	 	   Thread.sleep(1000);
	 	    Select select1=new Select(Country);
	 	    select1.selectByVisibleText("India");
	 	   driver.findElement(zipCode).sendKeys("560092");
	 	  WebElement click=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("termsofservice")));
		    click.click();
		    Thread.sleep(1000);
		    WebElement checkout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
		    checkout.click();
		    Thread.sleep(1000);
	    }

	    public void clickContinue() throws InterruptedException {
	        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	        Thread.sleep(1000);
	    }
	    public void clickContinue2() throws InterruptedException {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")));
	 	    link.click();
	 	   Thread.sleep(1000);
	    }
	    public void clickContinue3() {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")));
	 	    link.click();
	    }
	    public void clickContinue4() {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")));
	 	    link.click();
	    }
	    public void clickContinue5() {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")));
	 	    link.click();
	    }
	    public void submit() {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")));
	 	    link.click();
	    }
	    public void submit2() {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")));
	 	    link.click();
	    }
	    public void display() {
	    	WebElement link=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")));
	    	  link.click();
//	    	String expectedTitle="Your order has been successfully processed!";
//	    	String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
//	        boolean isTitleCorrect = actualTitle.equals(expectedTitle);

	    }
	}


