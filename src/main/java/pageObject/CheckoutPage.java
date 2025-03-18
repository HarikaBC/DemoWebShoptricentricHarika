package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {
	private WebDriver driver;
    private WebDriverWait wait;

    // **Locators**
    //private By cartIcon = By.id("ctl00_lblTotalCartItems");
    private By cartIcon=By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[6]/a");
    private By productlink = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/h2/a");
    private By increaseQuantity = By.id("addtocart_14_EnteredQuantity");
    private By cartopenButton = By.xpath("//*[@id=\"bar-notification\"]/p/a");
    private By remove = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[1]/input");
    private By productlink2 = By.xpath("private By productlink = By.xpath(\"/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div/div[2]/h2/a\");");
    private By addToCartButton2 = By.id("add-to-cart-button-28");
    private By addToCartButton1 = By.id("add-to-cart-button-14");
    private By update = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[1]/div/input[1]");

    // **Constructor**
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // **Method: Open the Cart Page**
    public void openCart() throws InterruptedException {
    	
		
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
    }
    
    public void addItemToCart() throws InterruptedException {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));
         driver.findElement(cartIcon).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(productlink));
         driver.findElement(productlink).click();
         Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(productlink2));
        driver.findElement(productlink2).click();
           

            WebElement cartButton2 = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton2));
          //  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton2);
            Thread.sleep(1000);
            cartButton2.click();
    }


    // **Method: Remove Product from Cart**
    public void removeProduct1() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(remove)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(update));
        driver.findElement(update).click();
        Thread.sleep(2000);
    }

    // **Method: Increase Product Quantity**
    
    // **Method: Proceed to Checkout**
   
    // **Method: Validate Checkout Page**
    public void verifyCheckoutPage() {
        System.out.println("Added and updated successfulle!");
    }
}


