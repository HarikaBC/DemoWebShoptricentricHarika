package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // **Locators**
    public By productTitle = By.id("Demo Web Shop. 14.1-inch Laptop");
    public By productDescription = By.id("Unique Asian-influenced imprint wraps the laptop both inside and out");
    public By pPrice = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[5]/div/span");
    public By pImage = By.id("main-product-img-31");
    public By addtocartButton = By.xpath("//*[@id=\"add-to-cart-button-31\"]");

    // **Constructor**
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // **Method: Validate product details (returns boolean instead of Assert)**
    public boolean validateProductDetails(String expectedTitle, String expectedDescription, int minPrice, int maxPrice) throws InterruptedException {
        // **Title Check**
        String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
        boolean isTitleCorrect = actualTitle.equals(expectedTitle);

        // **Description Check**
        String actualDescription = driver.findElement(productDescription).getText();
        boolean isDescriptionCorrect = actualDescription.equals(expectedDescription);

        // **Price Check**
        String priceText = driver.findElement(pPrice).getText().replaceAll("[^0-9.]", "").trim();
        double productPriceValue = Double.parseDouble(priceText);
        boolean isPriceWithinRange = productPriceValue >= minPrice && productPriceValue <= maxPrice;
        
        Thread.sleep(3000);

        // **Image & Availability Check**
        boolean isImageDisplayed = driver.findElement(pImage).isDisplayed();

        // Return true only if all validations pass
        return isTitleCorrect && isDescriptionCorrect && isPriceWithinRange && isImageDisplayed;
    }

    // **Method: Enter quantity**
    public void quantity() {
        driver.findElement(By.id("addtocart_31_EnteredQuantity")).sendKeys("1");
    }

    // **Method: Add product to cart**
    public void addToCart() {
        WebElement addtocart = wait.until(ExpectedConditions.elementToBeClickable(addtocartButton));
        addtocart.click();
    }
}
