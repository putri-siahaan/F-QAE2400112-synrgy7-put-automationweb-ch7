package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By productInHomepage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By shoppingCartImage = By.id("shopping_cart_container");



    public HomePage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver = driver;
    }

    //Method Action
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public String getProductInHomepage(){
        return driver.findElement(productInHomepage).getText();
    }

    public void shoppingCartIsDisplayed(){
        driver.findElement(shoppingCartImage).isDisplayed();
    }

}
