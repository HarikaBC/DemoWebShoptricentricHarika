package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // **Locators**
    public By Register = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    //private By signupLink = By.cssSelector(".themecolor.d-block.w-100.mb-3.font-weight-bold.signuplink");
    public By loginLink = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    public By emailField = By.id("Email");
    public By passwordField = By.id("Password");
    public By loginButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");
    public By name=By.id("FirstName");
    public By lname=By.id("LastName");
    public By fpassword=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/span/a");
    public By confirmPasswordField = By.id("ConfirmPassword");
    public By submitregisterButton = By.id("register-button");
    public By registerMessage = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]");
    public By recoverbutton=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/form/div[2]/input");
    // **Constructor**
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

   
    public void clickSignup() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(Register)).click();
        WebElement genderRadioButton = driver.findElement(By.id("gender-female"));
        genderRadioButton.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys("Harikaa");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lname)).sendKeys(" C");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys("xyzltygmno@gmail.com");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys("12345678id");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys("12345678id");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitregisterButton)).click();
        Thread.sleep(2000);
        
    }

    // **Method: Click on Login**
    public void clickLogin() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        Thread.sleep(2000);
    }
    public void clickforgot() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(fpassword)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys("xyzltygmno@gmail.com");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(recoverbutton)).click();
        Thread.sleep(2000);
    }

    // **Method: Login to Account**
    public void login(String email, String password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Thread.sleep(2000);
    }

    

    // **Method: Check if Password Change was Successful**
    public boolean isregisteredSuccessfully() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerMessage)).isDisplayed();
        
    }
}
