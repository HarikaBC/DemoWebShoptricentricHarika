package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;

	// Locators
	public By searchBar = By.id("small-searchterms");
	 public By searchButton = By.xpath("//input[@type='submit']");

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to enter a book name in the search bar
	public void searchForproduct(String product) {
		driver.findElement(searchBar).sendKeys(product);
		driver.findElement(searchButton).click();
	}

	// Method to get the page title
	public String getPageTitle() {
		return driver.getTitle();
	}

}


