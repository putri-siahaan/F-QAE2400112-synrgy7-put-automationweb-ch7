package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Page {
    WebDriver driver;
    WebDriverWait wait;

    By usernameFieldForLogin = By.id("user-name");
    By passwordFieldForLogin = By.id("password");
    By buttonForLogin = By.id("login-button");

    //Failed Login
    By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public Login_Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Method for Login

    public void inputUsernameToLogin(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldForLogin));
        driver.findElement(usernameFieldForLogin).sendKeys(username);
    }

    public void inputPasswordToLogin(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldForLogin));
        driver.findElement(passwordFieldForLogin).sendKeys(password);
    }

    public void clickLoginButtonToGoToHomepage(){
        driver.findElement(buttonForLogin).click();
    }



    //Failed Login
    public void stayInTheLoginPage(){
        driver.findElement(buttonForLogin).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
